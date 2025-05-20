package com.example.uijp.gulaDarah.ui


import android.app.DatePickerDialog
import android.app.TimePickerDialog
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.KeyboardArrowLeft
import androidx.compose.material.icons.filled.AccessTime
import androidx.compose.material.icons.filled.DateRange
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.uijp.GulaDarahViewModel
import kotlinx.coroutines.launch
import java.text.SimpleDateFormat
import java.util.*

@Composable
fun InsertPages(viewModel: GulaDarahViewModel, navController: NavController) {
    val context = LocalContext.current
    val scope = rememberCoroutineScope()
    val calendar = Calendar.getInstance()
    val snackbarHostState = remember { SnackbarHostState() }

    var gulaDarah by remember { mutableStateOf("") }
    var tanggal by remember { mutableStateOf(SimpleDateFormat("dd MMM yyyy", Locale("id", "ID")).format(Date()).uppercase()) }
    var jam by remember { mutableStateOf(SimpleDateFormat("HH:mm", Locale.getDefault()).format(Date())) }

    fun showDatePicker() {
        DatePickerDialog(
            context,
            { _, year, month, dayOfMonth ->
                val calendar = Calendar.getInstance()
                calendar.set(year, month, dayOfMonth)
                tanggal = SimpleDateFormat("dd MMM yyyy", Locale("id", "ID")).format(calendar.time).uppercase()
            },
            calendar.get(Calendar.YEAR),
            calendar.get(Calendar.MONTH),
            calendar.get(Calendar.DAY_OF_MONTH)
        ).show()
    }

    fun showTimePicker() {
        TimePickerDialog(
            context,
            { _, hour, minute ->
                jam = String.format("%02d:%02d", hour, minute)
            },
            calendar.get(Calendar.HOUR_OF_DAY),
            calendar.get(Calendar.MINUTE),
            true
        ).show()
    }

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(color = Color(0xFFF67669))
    ) {


        Row (
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 60.dp),
            verticalAlignment = Alignment.CenterVertically
        ){
            IconButton(
                modifier = Modifier.padding(start = 18.dp),
                onClick = { navController.navigate("guladarah") }
            ) {
                Icon(
                    imageVector = Icons.AutoMirrored.Filled.KeyboardArrowLeft,
                    contentDescription = "Back Button",
                    tint = Color.Black,
                    modifier = Modifier.size(30.dp)
                )
            }
            Text(
                "Input Gula Darah",
                style = TextStyle(
                    fontSize = 20.sp,
                    fontWeight = FontWeight.Bold,
                    color = Color(0xFF181818),
                    textAlign = TextAlign.Center,
                ),
                modifier = Modifier
                    .weight(1f)
                    .padding(end = 50.dp)
            )
        }

        Card(
            modifier = Modifier
                .fillMaxSize()
                .padding(top = 145.dp)
            ,
            colors = CardDefaults.cardColors(containerColor = Color.White),
            shape = RoundedCornerShape(topStart = 40.dp, topEnd = 40.dp)
        ) {

            Column(
                modifier = Modifier.fillMaxSize()
            ) {
                Column (
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(top = 39.dp, start = 31.dp)
                ){
                    Text(
                        "Input Gula Darah (mg/dL)",
                        style = TextStyle(
                            fontSize = 14.sp,
                            fontWeight = FontWeight.SemiBold,
                            color = Color(0xFF666666),
                            letterSpacing = 0.84.sp,
                        )
                    )
                    Spacer(modifier = Modifier.height(17.dp))

                    OutlinedTextField(
                        value = gulaDarah,
                        onValueChange = { gulaDarah = it },
                        placeholder = {},
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(50.dp)
                            .padding(end = 31.dp),
                        shape = RoundedCornerShape(8.dp),
                        textStyle = TextStyle(fontSize = 10.sp),
                        singleLine = true
                    )
                }

                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(top = 21.dp, start = 31.dp)
                ){
                    Text(
                        "Input Tanggal",
                        style = TextStyle(
                            fontSize = 14.sp,
                            fontWeight = FontWeight.SemiBold,
                            color = Color(0xFF666666),
                            letterSpacing = 0.84.sp,
                        )
                    )
                    Spacer(modifier = Modifier.height(17.dp))

                    OutlinedTextField(
                        value = tanggal,
                        onValueChange = {},
                        placeholder = {},
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(50.dp)
                            .padding(end = 31.dp),
                        shape = RoundedCornerShape(8.dp),
                        textStyle = TextStyle(fontSize = 10.sp),
                        singleLine = true,
                        trailingIcon = {
                            IconButton(onClick = { showDatePicker() }) {
                                Icon(Icons.Default.DateRange, contentDescription = "Pick Date")
                            }
                        }
                    )
                }

                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(top = 21.dp, start = 31.dp)
                ){
                    Text(
                        "Input Jam",
                        style = TextStyle(
                            fontSize = 14.sp,
                            fontWeight = FontWeight.SemiBold,
                            color = Color(0xFF666666),
                            letterSpacing = 0.84.sp,
                        )
                    )
                    Spacer(modifier = Modifier.height(17.dp))

                    OutlinedTextField(
                        value = jam,
                        onValueChange = {},
                        placeholder = {},
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(50.dp)
                            .padding(end = 31.dp),
                        shape = RoundedCornerShape(8.dp),
                        textStyle = TextStyle(fontSize = 10.sp),
                        singleLine = true,
                        trailingIcon = {
                            IconButton(onClick = { showTimePicker() }) {
                                Icon(Icons.Default.AccessTime, contentDescription = "Pick Time")
                            }
                        }
                    )
                }


                Spacer(modifier = Modifier.height(220.dp))

                Button(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(start = 31.dp, end = 31.dp)
                        .width(319.dp)
                        .height(42.dp),
                    shape = RoundedCornerShape(8.dp),
                    onClick = {
                        if (gulaDarah.isNotEmpty()) {
                            val gulaDarahInt = gulaDarah.toIntOrNull()
                            if (gulaDarahInt != null) {
                                scope.launch {
                                    try {

                                        viewModel.insertGulaDarah(tanggal, jam, gulaDarahInt)

                                        snackbarHostState.showSnackbar("Data berhasil disimpan")

                                        gulaDarah = ""

                                        navController.navigate("guladarah") {

                                            popUpTo("guladarah") {
                                                inclusive = true
                                            }
                                        }
                                    } catch (e: Exception) {
                                        snackbarHostState.showSnackbar("Error: ${e.localizedMessage ?: "Unknown error"}")
                                    }
                                }
                            } else {
                                scope.launch {
                                    snackbarHostState.showSnackbar("Nilai gula darah harus berupa angka")
                                }
                            }
                        } else {
                            scope.launch {
                                snackbarHostState.showSnackbar("Harap masukkan nilai gula darah")
                            }
                        }
                    },
                    colors = ButtonDefaults.buttonColors(
                        containerColor = Color(0xFFF67669)
                    )
                ) {
                    Text("Tambahkan Gula Darah")
                }

                SnackbarHost(
                    hostState = snackbarHostState,
                )
            }
        }
}
}