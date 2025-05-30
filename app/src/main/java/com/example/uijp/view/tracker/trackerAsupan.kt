package com.example.uijp.view.tracker

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll


import androidx.navigation.NavController

@Composable
fun TrackerGulaScreen(navController: NavController) {
    val makananList = listOf(
        Triple("Teh Manis", "12.0g", "08:00 AM"),
        Triple("Nasi Goreng", "2.5g", "12:30 PM"),
        Triple("Roti Cokelat", "8.0g", "04:15 PM"),
        Triple("Jus Jeruk", "10.0g", "07:00 PM"),
    )

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White)
            .padding(24.dp)
            .verticalScroll(rememberScrollState())  // Menambahkan vertical scroll
    ) {
        // Header
        Box(
            modifier = Modifier
                .height(64.dp)
                .fillMaxWidth()
        ) {
            IconButton(modifier = Modifier.align(Alignment.CenterStart), onClick = {
                navController.navigate("home")
            }) {
                Icon(
                    imageVector = Icons.Default.ArrowBack,
                    contentDescription = null,
                    tint = Color.Black
                )
            }

            Text(
                "Tracker Asupan Gula Harian",
                modifier = Modifier.align(Alignment.Center),
                fontSize = 22.sp,
                fontWeight = FontWeight.SemiBold,
                color = Color.Black
            )
        }

        Spacer(Modifier.height(36.dp))

        // Konsumsi Gula Harian
        Card(
            shape = RoundedCornerShape(16.dp),
            backgroundColor = Color(0xFFFFFFFF),
            modifier = Modifier.fillMaxWidth(),
            elevation = 0.dp
        ) {
            Column(
                modifier = Modifier.padding(24.dp),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                CircularProgressIndicator(
                    progress = 0.75f,
                    modifier = Modifier.size(100.dp),
                    strokeWidth = 10.dp,
                    backgroundColor = Color(0xFFFFFFFF),
                    color = Color(0xFFF67669)
                )
                Spacer(modifier = Modifier.height(16.dp))
                Text("32.5g / 40g", fontWeight = FontWeight.Bold, fontSize = 18.sp)
                Text(
                    "Status: Mendekati Batas Harian",
                    fontSize = 14.sp,
                    color = Color(0xFF7A7A7A),
                    fontWeight = FontWeight.Medium
                )
            }
        }

        Spacer(Modifier.height(36.dp))

        Text("Daftar Makanan Hari Ini", fontSize = 16.sp, fontWeight = FontWeight.SemiBold)

        Spacer(modifier = Modifier.height(16.dp))

        makananList.forEach { (nama, gula, waktu) ->
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 8.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Box(
                    modifier = Modifier
                        .size(48.dp)
                        .clip(CircleShape)
                        .background(Color(0xFFEAEAEA))
                )
                Spacer(modifier = Modifier.width(12.dp))
                Column(modifier = Modifier.weight(1f)) {
                    Text(nama, fontWeight = FontWeight.SemiBold, fontSize = 14.sp)
                    Text("Kandungan gula: $gula", fontSize = 12.sp, color = Color(0xFF7A7A7A))
                }
                Text(waktu, fontSize = 12.sp, color = Color(0xFF999999))
            }
        }

        Spacer(modifier = Modifier.height(24.dp))

        // Tombol dengan warna oranye
        Button(
            onClick = {navController.navigate("tambahmakanan")},
            modifier = Modifier
                .fillMaxWidth()
                .height(48.dp)
                .padding(top = 10.dp),
            colors = ButtonDefaults.buttonColors(
                backgroundColor = Color(0xFFF67669)
            ),
            shape = RoundedCornerShape(8.dp)
        ) {
            Text("Tambah Makanan", color = Color.White, fontWeight = FontWeight.SemiBold)
        }
    }
}
