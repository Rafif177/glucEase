package com.example.uijp.artikel

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.FavoriteBorder
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.uijp.R
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.zIndex
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController


@Composable
fun DetailArtikelScreen(
    judul: String,
    navController: NavController
) {
    Scaffold { paddingValues ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .verticalScroll(rememberScrollState())
                .padding(paddingValues)
        ) {
            Box {
                Image(
                    painter = painterResource(id = R.drawable.artikel1),
                    contentDescription = "Gambar Artikel",
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(280.dp),
                    contentScale = ContentScale.Crop
                )

                IconButton(
                    onClick = { navController.popBackStack() },
                    modifier = Modifier
                        .padding(16.dp)
                        .background(Color.White.copy(alpha = 0.7f), shape = CircleShape)
                        .size(36.dp)
                ) {
                    Icon(Icons.Default.ArrowBack, contentDescription = "Back")
                }

                IconButton(
                    onClick = { /* TODO: Like action */ },
                    modifier = Modifier
                        .align(Alignment.BottomEnd)
                        .padding(16.dp) // ⚠️ Hapus offset berlebih
                        .background(Color(0xFFFFD9CF), shape = CircleShape)
                        .size(56.dp)
                ) {
                    Icon(
                        imageVector = Icons.Default.FavoriteBorder,
                        contentDescription = "Like",
                        tint = Color(0xFFE86A33)
                    )
                }

                Text(
                    text = judul,
                    style = MaterialTheme.typography.titleLarge.copy(
                        fontWeight = FontWeight.Bold,
                        fontSize = 22.sp,
                        color = Color.White
                    ),
                    modifier = Modifier
                        .align(Alignment.BottomStart)
                        .padding(16.dp)
                        .padding(8.dp)
                )
            }

            Spacer(modifier = Modifier.height(16.dp))

            Row(
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier.padding(16.dp)
            ) {
                Box(
                    modifier = Modifier
                        .size(36.dp)
                        .background(Color(0xFFE8EDF3), shape = CircleShape),
                    contentAlignment = Alignment.Center
                ) {
                    Text("UI", color = Color.Black)
                }
                Spacer(modifier = Modifier.width(8.dp))
                Column {
                    Text("Beby Ayu", style = MaterialTheme.typography.labelMedium)
                    Text("17 Jam lalu", style = MaterialTheme.typography.labelSmall)
                }
            }

            Text(
                text = "Gula darah yang tidak stabil adalah masalah kesehatan yang sering kali diabaikan, padahal dapat menyebabkan berbagai komplikasi serius, terutama pada penderita diabetes. Gula darah yang terlalu tinggi (hiperglikemia) atau terlalu rendah (hipoglikemia) dapat memengaruhi kesehatan tubuh secara keseluruhan. Oleh karena itu, sangat penting untuk mengenali tanda-tanda gula darah yang tidak stabil agar dapat segera ditangani.\n" +
                        "\n" +
                        "✨Tanda-Tanda Gula Darah Tinggi (Hiperglikemia)✨\n" +
                        "1. Sering Buang Air Kecil\n" +
                        "Jika tubuh memiliki kadar gula darah yang tinggi, ginjal akan bekerja lebih keras untuk mengeluarkan kelebihan gula tersebut. Hal ini menyebabkan frekuensi buang air kecil menjadi lebih sering dari biasanya.\n" +
                        "\n" +
                        "2. Rasa Haus Berlebihan\n" +
                        "Kadar gula darah yang tinggi menyebabkan tubuh kehilangan banyak cairan, yang akhirnya memicu rasa haus yang berlebihan. Anda mungkin merasa selalu ingin minum meskipun sudah banyak mengonsumsi air.\n" +
                        "\n" +
                        "3. Kelelahan\n" +
                        "Gula darah yang tinggi dapat mengganggu metabolisme tubuh, menyebabkan rasa lelah yang berlebihan meski Anda sudah cukup tidur dan beristirahat.\n" +
                        "\n" +
                        "4. Penglihatan Kabur\n" +
                        "Kadar gula darah yang tidak terkendali dapat memengaruhi lensa mata, menyebabkan penglihatan kabur. Hal ini terjadi karena perubahan cairan di dalam tubuh yang memengaruhi bentuk lensa mata.\n" +
                        "\n" +
                        "5. Luka yang Sulit Sembuh\n" +
                        "Hiperglikemia dapat mengganggu kemampuan tubuh untuk menyembuhkan luka, menyebabkan luka atau goresan menjadi lebih lama sembuhnya.\n" +
                        "\n" +
                        "✨Tanda-Tanda Gula Darah Rendah (Hipoglikemia)✨\n" +
                        "1. Keringat Dingin\n" +
                        "Jika gula darah turun drastis, tubuh akan merespons dengan gejala keringat dingin. Anda bisa merasa basah kuyup meskipun cuaca tidak terlalu panas.\n" +
                        "\n" +
                        "2. Pusing dan Gemetar\n" +
                        "Kekurangan gula darah dapat menyebabkan rasa pusing yang hebat dan tubuh menjadi gemetar. Kondisi ini terjadi karena tubuh kekurangan bahan bakar untuk berfungsi dengan baik.\n" +
                        "\n" +
                        "3. Kebingungan dan Kelelahan Mental\n" +
                        "Ketika gula darah rendah, otak kekurangan energi, yang menyebabkan kebingungan, kesulitan berkonsentrasi, dan bahkan disorientasi.\n" +
                        "\n" +
                        "4. Cepat Marah\n" +
                        "Penurunan kadar gula darah dapat memengaruhi mood, membuat seseorang lebih mudah marah atau merasa cemas tanpa alasan yang jelas.\n" +
                        "\n" +
                        "5. Pusing atau Kehilangan Kesadaran\n" +
                        "Jika kadar gula darah sangat rendah, bisa berujung pada pusing ekstrem atau bahkan pingsan. Ini adalah tanda darurat medis yang membutuhkan perhatian segera.\n" +
                        "\n" +
                        "✨Mengapa Gula Darah Tidak Stabil Berbahaya?✨\n" +
                        "Kondisi gula darah yang tidak stabil, baik tinggi maupun rendah, dapat menyebabkan berbagai komplikasi kesehatan jangka panjang, seperti kerusakan pada pembuluh darah, jantung, ginjal, dan saraf. Jika dibiarkan tanpa pengobatan, diabetes juga dapat menyebabkan kebutaan, gangren, dan bahkan kematian.\n" +
                        "\n" +
                        "✨Bagaimana Cara Menjaga Gula Darah Tetap Stabil?✨\n" +
                        "1. Diet Sehat\n" +
                        "Mengonsumsi makanan bergizi dan seimbang sangat penting untuk menjaga kestabilan gula darah. Pilih makanan yang memiliki indeks glikemik rendah, seperti sayuran hijau, biji-bijian, dan protein tanpa lemak.\n" +
                        "\n" +
                        "2. Olahraga Rutin\n" +
                        "Aktivitas fisik secara teratur membantu tubuh mengatur kadar gula darah. Cobalah untuk berolahraga setidaknya 30 menit setiap hari.\n" +
                        "\n" +
                        "3. Pantau Kadar Gula Darah\n" +
                        "Bagi penderita diabetes, penting untuk memantau kadar gula darah secara rutin. Dengan alat pengukur gula darah, Anda bisa mengetahui apakah kadar gula darah Anda berada dalam rentang yang aman.\n" +
                        "\n" +
                        "4. Pengelolaan Stres\n" +
                        "Stres dapat memengaruhi kadar gula darah. Cobalah teknik relaksasi seperti meditasi, yoga, atau pernapasan dalam untuk mengurangi stres.\n" +
                        "\n" +
                        "5. Konsultasi dengan Dokter\n" +
                        "Jika Anda merasa gejala gula darah tidak stabil atau memiliki riwayat diabetes, segera konsultasikan dengan dokter untuk mendapatkan perawatan yang tepat.\n" +
                        "\n" +
                        "✨Kesimpulan✨\n" +
                        "Mengenali tanda-tanda gula darah yang tidak stabil sejak dini sangat penting untuk mencegah terjadinya komplikasi serius. Dengan menjaga pola makan, rutin berolahraga, dan memantau kadar gula darah, Anda dapat mengurangi risiko terkena masalah gula darah yang berbahaya. Jangan ragu untuk berkonsultasi dengan tenaga medis jika Anda merasa ada yang tidak beres dengan kesehatan gula darah Anda.\n" +
                        "\n",
                style = MaterialTheme.typography.bodyMedium,
                modifier = Modifier
                    .padding(horizontal = 16.dp)
                    .padding(bottom = 24.dp)
            )
        }
    }
}
