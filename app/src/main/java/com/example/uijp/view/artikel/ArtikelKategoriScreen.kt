package com.example.uijp.view.artikel

import android.util.Log
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.uijp.R

@Composable
fun ArtikelKategoriScreen(navController: NavController, kategoriName: String) {
    Column(modifier = Modifier
        .fillMaxSize()
        .padding(16.dp)) {

        // Icon Kembali di sebelah kiri atas
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(bottom = 12.dp),
            horizontalArrangement = Arrangement.Start
        ) {
            IconButton(onClick = {
                navController.navigate("artikel") {
                    popUpTo(navController.graph.startDestinationId) {
                        inclusive = false
                    }
                    launchSingleTop = true
                }
            }) {
                Image(
                    painter = painterResource(id = R.drawable.ic_back),
                    contentDescription = "Kembali",
                    modifier = Modifier.size(24.dp)
                )
            }
        }

        // Judul Halaman
        Text(
            text = kategoriName,
            style = MaterialTheme.typography.headlineSmall,
            modifier = Modifier.padding(bottom = 12.dp)
        )

        // Search Bar (belum aktif)
        OutlinedTextField(
            value = "",
            onValueChange = {},
            placeholder = { Text("Search") },
            modifier = Modifier
                .fillMaxWidth()
                .padding(bottom = 16.dp),
            shape = RoundedCornerShape(25.dp),
            singleLine = true
        )

        // Daftar Artikel - Setiap artikel bisa diklik untuk navigasi ke detail
        ArtikelCard(
            kategori = "UI",
            user = "Beby Ayu",
            judul = "Kenali Tanda-Tanda Gula Darah Tidak Stabil Sebelum Terlambat",
            waktu = "17 Jam lalu",
            imageRes = R.drawable.artikel1,
            onClick = { navController.navigate("detail/Kenali Tanda-Tanda Gula Darah Tidak Stabil Sebelum Terlambat") }
        )

        ArtikelCard(
            kategori = "UI",
            user = "User",
            judul = "Aktivitas Ringan yang Efektif Menurunkan Gula Darah",
            waktu = "Kemarin",
            imageRes = R.drawable.artikel2,
            onClick = { navController.navigate("detail/Aktivitas Ringan yang Efektif Menurunkan Gula Darah") }
        )

        ArtikelCard(
            kategori = "UX",
            user = "User",
            judul = "Kapan Waktu Terbaik untuk Cek Gula Darah?",
            waktu = "2 hari yang lalu",
            imageRes = R.drawable.artikel3,
            onClick = { navController.navigate("detail/Kapan Waktu Terbaik untuk Cek Gula Darah?") }
        )
    }
}

@Composable
fun ArtikelCard(
    kategori: String,
    user: String,
    judul: String,
    waktu: String,
    imageRes: Int,
    onClick: () -> Unit // fungsi yang dipanggil saat artikel diklik
) {
    // Komponen kartu artikel
    Card(
        shape = RoundedCornerShape(16.dp),
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 8.dp)
            .clickable { onClick() } // Navigasi saat kartu diklik
    ) {
        // Baris horizontal: Info artikel (kiri) + gambar (kanan)
        Row(
            modifier = Modifier
                .padding(12.dp)
        ) {
            // Kolom berisi info teks artikel
            Column(modifier = Modifier.weight(1f)) {
                // Label kategori + user
                Row(verticalAlignment = Alignment.CenterVertically) {
                    // Lingkaran label kategori
                    Box(
                        modifier = Modifier
                            .size(24.dp)
                            .clip(CircleShape)
                            .background(
                                if (kategori == "UI") Color(0xFFFFC1C1) else Color(0xFFB39DDB)
                            ),
                        contentAlignment = Alignment.Center
                    ) {
                        Text(
                            text = kategori,
                            fontSize = 10.sp,
                            fontWeight = FontWeight.Bold,
                            color = Color.White
                        )
                    }
                    Spacer(modifier = Modifier.width(8.dp))
                    Text(text = user, fontSize = 12.sp, color = Color.Gray)
                }

                Spacer(modifier = Modifier.height(8.dp))

                // Judul artikel
                Text(
                    text = judul,
                    fontSize = 16.sp,
                    fontWeight = FontWeight.Bold
                )

                Spacer(modifier = Modifier.height(8.dp))

                // Waktu publish
                Text(text = waktu, fontSize = 12.sp, color = Color.Gray)
            }

            Spacer(modifier = Modifier.width(12.dp))

            // Gambar thumbnail
            Image(
                painter = painterResource(id = imageRes),
                contentDescription = "Thumbnail",
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .size(80.dp)
                    .clip(RoundedCornerShape(8.dp))
            )
        }
    }
}


