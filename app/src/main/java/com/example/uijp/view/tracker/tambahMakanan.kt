package com.example.uijp.view.tracker

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Search
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.uijp.R

@Composable
fun TambahMakananScreen(navController: NavController) {
    val makananList = listOf(
        Makanan("Nasi Putih", "0.1g", "45g", "4g", R.drawable.nasiputih),
        Makanan("Roti Cokelat", "8g", "30g", "5g", R.drawable.nasiputih),
        Makanan("Teh Manis", "12g", "12g", null, R.drawable.nasiputih),
        Makanan("Nasi Putih", "0.1g", "45g", "4g", R.drawable.nasiputih),
        Makanan("Roti Cokelat", "8g", "30g", "5g", R.drawable.nasiputih),
        Makanan("Teh Manis", "12g", "12g", null, R.drawable.nasiputih),
    )

    var searchQuery by remember { mutableStateOf("") }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White)
            .padding(horizontal = 16.dp)
    ) {
        Spacer(modifier = Modifier.height(16.dp))

        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier.fillMaxWidth()
        ) {
            IconButton(onClick = { navController.popBackStack() }) {
                Icon(
                    imageVector = Icons.Default.ArrowBack,
                    contentDescription = "Kembali"
                )
            }
            Spacer(modifier = Modifier.width(8.dp))
            Text(
                text = "Tambah Makanan",
                style = MaterialTheme.typography.titleLarge,
                modifier = Modifier.weight(1f)
            )
        }

        Spacer(modifier = Modifier.height(12.dp))

        OutlinedTextField(
            value = searchQuery,
            onValueChange = { searchQuery = it },
            leadingIcon = { Icon(Icons.Default.Search, contentDescription = null) },
            placeholder = { Text("Cari makanan...") },
            modifier = Modifier
                .fillMaxWidth()
                .clip(RoundedCornerShape(16.dp)),
            colors = OutlinedTextFieldDefaults.colors(
                focusedBorderColor = Color.Gray,
                unfocusedBorderColor = Color.LightGray,
                focusedContainerColor = Color(0xFFF6F6F6),
                unfocusedContainerColor = Color(0xFFF6F6F6)
            )
        )

        Spacer(modifier = Modifier.height(12.dp))

        Text(
            text = "List makanan yang pernah dikonsumsi",
            fontSize = 14.sp,
            color = Color.Gray
        )

        Spacer(modifier = Modifier.height(8.dp))

        LazyColumn {
            items(makananList.filter {
                it.nama.contains(searchQuery, ignoreCase = true)
            }) { makanan ->
                MakananItem(makanan = makanan)
            }
        }
    }
}

@Composable
fun MakananItem(makanan: Makanan) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 8.dp)
    ) {
        Image(
            painter = painterResource(id = makanan.imageRes),
            contentDescription = makanan.nama,
            modifier = Modifier
                .size(50.dp)
                .clip(RoundedCornerShape(12.dp))
                .background(Color(0xFFFFE5E0))
                .padding(4.dp)
        )

        Spacer(modifier = Modifier.width(12.dp))

        Column {
            Text(
                text = makanan.nama,
                fontSize = 16.sp,
                style = MaterialTheme.typography.bodyLarge
            )
            Spacer(modifier = Modifier.height(4.dp))
            Row(verticalAlignment = Alignment.CenterVertically) {
                Text("Gula: ${makanan.gula}", fontSize = 12.sp, color = Color.Gray)
                Spacer(modifier = Modifier.width(8.dp))
                Text("Karbo: ${makanan.karbo}", fontSize = 12.sp, color = Color.Gray)
                makanan.protein?.let {
                    Spacer(modifier = Modifier.width(8.dp))
                    Text("Protein: $it", fontSize = 12.sp, color = Color.Gray)
                }
            }
        }
    }
}

data class Makanan(
    val nama: String,
    val gula: String,
    val karbo: String,
    val protein: String?,
    val imageRes: Int
)
