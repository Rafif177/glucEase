package com.example.uijp.artikel

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
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.ChevronRight
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.uijp.R
import androidx.compose.material3.OutlinedTextFieldDefaults

@Composable
fun ArtikelScreen(navController: NavController) {
    // Scaffold adalah kerangka dasar dari UI kita, berisi top bar, bottom bar, dsb.
    // Di sini kita hanya menggunakan bagian kontennya saja.
    Scaffold { paddingValues ->
        // Column untuk menyusun elemen UI secara vertikal
        Column(
            modifier = Modifier
                .padding(paddingValues) // padding dari Scaffold
                .verticalScroll(rememberScrollState()) // memungkinkan layar di-scroll
                .padding(horizontal = 16.dp, vertical = 6.dp) // padding tambahan
        ) {
            // Row untuk menambahkan tombol back di atas
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 6.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                // Tombol back
                Icon(
                    imageVector = Icons.Default.ArrowBack,
                    contentDescription = "Back",
                    modifier = Modifier
                        .clickable { navController.navigate("home") }
                        .padding(end = 8.dp)
                )
                // Judul Halaman
                Text(
                    text = "Artikel & Edukasi",
                    style = MaterialTheme.typography.headlineSmall,
                    textAlign = TextAlign.Start
                )
            }

            Spacer(modifier = Modifier.height(16.dp))

            // Komponen pencarian (search bar)
            SearchBar()

            Spacer(modifier = Modifier.height(16.dp))

            val kategoriData = listOf(
                Triple("Terpopuler-Terbaru", listOf("Kapan Waktu Terbaik...", "Cek Gula Darah Rutin"), listOf(R.drawable.cek_gula_darah, R.drawable.artikel1)),
                Triple("Kesehatan", listOf("Kenali Tanda-Tanda...", "Aktivitas Ringan..."), listOf(R.drawable.artikel1, R.drawable.artikel2)),
                Triple("Lifestyle", listOf("Tidur yang Cukup", "Hidup Seimbang"), listOf(R.drawable.artikel3, R.drawable.artikel1))
            )

            kategoriData.forEach { (judulKategori, titles, imageResList) ->
                SectionHeader(title = judulKategori) {
                    navController.navigate("artikel_kategori/$judulKategori")
                }

                // Bisa pakai card besar kalau kategori populer
                if (judulKategori == "Terpopuler-Terbaru") {
                    PopularArticleCard(imageRes = imageResList.first())
                } else {
                    HorizontalArticleRow(
                        titles = titles,
                        imageRes = imageResList
                    )
                }

                Spacer(modifier = Modifier.height(16.dp))
            }
        }
    }
}

// Membuat fungsi SearchBar
@Composable
fun SearchBar() {
    // OutlinedTextField untuk search input
    OutlinedTextField(
        value = "", // belum terhubung ke state pencarian (kosong)
        onValueChange = {}, // belum ada logika pencarian
        placeholder = { Text("Search") }, // placeholder di dalam field
        leadingIcon = { Icon(Icons.Default.Search, contentDescription = null) }, // ikon kaca pembesar
        modifier = Modifier
            .fillMaxWidth()
            .clip(RoundedCornerShape(20.dp)), // sudut rounded
        colors = OutlinedTextFieldDefaults.colors(
            unfocusedBorderColor = Color.LightGray,
            focusedBorderColor = Color.Gray
        )
    )
}

// Membuat Komponen Header Kategori
@Composable
fun SectionHeader(title: String, onClick: () -> Unit) {
    // Header tiap bagian (misalnya: Kesehatan, Life style)
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .clickable { onClick() }
            .padding(vertical = 8.dp),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {
        // Judul kategori
        Text(
            text = title,
            style = MaterialTheme.typography.titleMedium.copy(fontWeight = FontWeight.Bold)
        )
        // Ikon panah (opsional navigasi ke halaman detail kategori)
        Icon(imageVector = Icons.Default.ChevronRight, contentDescription = null)
    }
}

// Membuat Komponen Artikel Populer
@Composable
fun PopularArticleCard(imageRes: Int) {
    // Kotak gambar besar dengan teks di bawah
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .height(200.dp)
            .clip(RoundedCornerShape(16.dp))
    ) {
        // Gambar dari drawable
        Image(
            painter = painterResource(id = imageRes),
            contentDescription = null,
            contentScale = ContentScale.Crop,
            modifier = Modifier.fillMaxSize()
        )
        // Teks di bagian bawah gambar
        Column(
            modifier = Modifier
                .align(Alignment.BottomStart)
                .padding(12.dp)
        ) {
            Text(
                text = "Kapan Waktu Terbaik untuk Cek Gula Darah?",
                color = Color.White,
                style = MaterialTheme.typography.bodyLarge.copy(fontWeight = FontWeight.Bold)
            )
            Text(
                text = "Baca selengkapnya",
                color = Color.White,
                style = MaterialTheme.typography.bodySmall
            )
        }
    }
}

// Membuat Barisan Artikel Horizontal (dalam Satu Kategori)
@Composable
fun HorizontalArticleRow(titles: List<String>, imageRes: List<Int>) {
    // LazyRow untuk menampilkan daftar artikel secara horizontal
    LazyRow {
        items(titles.size) { index ->
            // Setiap artikel
            ArticleItem(title = titles[index], imageRes = imageRes[index])
        }
    }
}

// Membuat Artikel Item
@Composable
fun ArticleItem(title: String, imageRes: Int) {
    Column(
        modifier = Modifier
            .padding(end = 12.dp)
            .width(160.dp)
            .clip(RoundedCornerShape(12.dp))
            .background(Color.White)
            .shadow(1.dp, RoundedCornerShape(12.dp))
    ) {
        // Gambar artikel
        Image(
            painter = painterResource(id = imageRes),
            contentDescription = null,
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .height(100.dp)
                .fillMaxWidth()
        )
        // Judul dan deskripsi
        Column(modifier = Modifier.padding(8.dp)) {
            Text(
                text = title,
                style = MaterialTheme.typography.titleSmall.copy(fontWeight = FontWeight.SemiBold),
                maxLines = 1,
                overflow = TextOverflow.Ellipsis // agar teks tidak meluber
            )
            Text(
                text = "Mudah lapar, cepat lelah...",
                style = MaterialTheme.typography.bodySmall,
                color = Color.Gray,
                maxLines = 2,
                overflow = TextOverflow.Ellipsis
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewArtikelScreen() {
    val navController = rememberNavController() // Dummy NavController
    ArtikelScreen(navController)
}
