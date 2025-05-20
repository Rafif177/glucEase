package com.example.uijp.datadiri

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.verticalScroll
import androidx.compose.foundation.background
import androidx.compose.foundation.rememberScrollState
import androidx.compose.material3.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowDropDown
import androidx.compose.material.icons.filled.DateRange
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.Alignment
import androidx.navigation.NavController
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.VisualTransformation

@Composable
fun PersonalDataScreen(navController: NavController) {
    val genderOptions = listOf("Laki-laki", "Perempuan")
    val puasaOptions = listOf("Setiap hari", "Kadang", "Tidak Pernah")

    var selectedGender by remember { mutableStateOf("") }
    var age by remember { mutableStateOf("") }
    var weight by remember { mutableStateOf("") }
    var height by remember { mutableStateOf("") }

    var selectedIntensity by remember { mutableStateOf("") }
    var selectedDate by remember { mutableStateOf("") }
    var neverChecked by remember { mutableStateOf(false) }
    var selectedPuasa by remember { mutableStateOf("") }

    val diseaseStates = remember {
        mutableStateMapOf(
            "Diabetes" to false,
            "Penyakit Jantung" to false,
            "Hipertensi (Tekanan Darah Tinggi)" to false,
            "Stroke" to false,
            "Kanker" to false
        )
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFFF67669)),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Spacer(modifier = Modifier.height(100.dp)) // Jeda atas

        Card(
            shape = RoundedCornerShape(topStart = 32.dp, topEnd = 32.dp),
            modifier = Modifier
                .fillMaxSize(),
            colors = CardDefaults.cardColors(containerColor = Color.White)
        ) {
            Column(
                modifier = Modifier
                    .padding(horizontal = 24.dp)
                    .verticalScroll(rememberScrollState())
            ) {
                Spacer(modifier = Modifier.height(24.dp))

                Text("Personalisasi Data Diri", fontSize = 20.sp, fontWeight = FontWeight.Bold, modifier = Modifier.padding(bottom = 16.dp))

                DropdownSelector(label = "Jenis Kelamin", options = genderOptions, selectedOption = selectedGender) {
                    selectedGender = it
                }

                Spacer(Modifier.height(16.dp))

                OutlinedTextField(
                    value = age,
                    onValueChange = { age = it },
                    label = { Text("Umur") },
                    modifier = Modifier.fillMaxWidth(),
                    keyboardOptions = KeyboardOptions.Default.copy(keyboardType = KeyboardType.Number)
                )

                Spacer(Modifier.height(16.dp))

                Row(horizontalArrangement = Arrangement.spacedBy(8.dp)) {
                    OutlinedTextField(
                        value = weight,
                        onValueChange = { weight = it },
                        label = { Text("Berat Badan (Kg)") },
                        modifier = Modifier.weight(1f),
                        keyboardOptions = KeyboardOptions.Default.copy(keyboardType = KeyboardType.Number)
                    )
                    OutlinedTextField(
                        value = height,
                        onValueChange = { height = it },
                        label = { Text("Tinggi Badan (Cm)") },
                        modifier = Modifier.weight(1f),
                        keyboardOptions = KeyboardOptions.Default.copy(keyboardType = KeyboardType.Number)
                    )
                }

                Spacer(Modifier.height(24.dp))

                Text("Intensitas Olahraga", fontWeight = FontWeight.SemiBold)
                val intensitas = listOf(
                    "Jarang" to "1 kali per minggu (minimal 30 menit setiap sesi)",
                    "Kadang" to "1-3 kali per minggu (minimal 30 menit setiap sesi)",
                    "Sering" to "4-5 kali per minggu (minimal 30 menit setiap sesi)",
                    "Rutin" to "5-7 kali per minggu (minimal 30 menit setiap sesi)"
                )
                intensitas.forEach { (label, desc) ->
                    Row(verticalAlignment = Alignment.CenterVertically) {
                        RadioButton(selected = selectedIntensity == label, onClick = { selectedIntensity = label })
                        Column {
                            Text(label)
                            Text(desc, fontSize = 12.sp, color = Color.Gray)
                        }
                    }
                }

                Spacer(Modifier.height(24.dp))

                OutlinedTextField(
                    value = selectedDate,
                    onValueChange = { selectedDate = it },
                    label = { Text("Kapan terakhir cek gula darah?") },
                    trailingIcon = { Icon(Icons.Default.DateRange, contentDescription = null) },
                    modifier = Modifier.fillMaxWidth()
                )
                Row(verticalAlignment = Alignment.CenterVertically) {
                    Checkbox(checked = neverChecked, onCheckedChange = { neverChecked = it })
                    Text("Belum Pernah")
                }

                Spacer(Modifier.height(16.dp))

                DropdownSelector(label = "Pilih kebiasaan puasa", options = puasaOptions, selectedOption = selectedPuasa) {
                    selectedPuasa = it
                }

                Spacer(Modifier.height(16.dp))

                Text("Riwayat Penyakit dalam Keluarga", fontWeight = FontWeight.SemiBold)
                diseaseStates.forEach { (disease, isChecked) ->
                    Row(verticalAlignment = Alignment.CenterVertically) {
                        Checkbox(checked = isChecked, onCheckedChange = { diseaseStates[disease] = it })
                        Text(disease)
                    }
                }

                Spacer(Modifier.height(24.dp))

                Button(
                    onClick = { navController.navigate("login") },
                    modifier = Modifier.fillMaxWidth().height(48.dp),
                    colors = ButtonDefaults.buttonColors(containerColor = Color(0xFFF67669))
                ) {
                    Text("Simpan", color = Color.White)
                }

                Spacer(Modifier.height(24.dp))
            }
        }
    }
}
