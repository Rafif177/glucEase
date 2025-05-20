package com.example.uijp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.*
import com.example.konsultasiprofil.UI.Screen.KonsultasiUi
import com.example.konsultasiprofil.UI.Screen.NotifikasiUI
import com.example.konsultasiprofil.UI.Screen.PembayaranUI
import com.example.konsultasiprofil.UI.Screen.PilihWaktuUI
import com.example.uijp.Gamifikasi.GamifikasiUI
import com.example.uijp.Gamifikasi.KlaimReward
import com.example.uijp.artikel.ArtikelKategoriScreen
import com.example.uijp.laporan.LaporanMingguanPage
import com.example.uijp.ui.LoginScreen
import com.example.uijp.ui.RegisterScreen
import com.example.uijp.artikel.ArtikelScreen
import com.example.uijp.artikel.DetailArtikelScreen
import com.example.uijp.datadiri.PersonalDataScreen
import com.example.uijp.freemium.GetPremiumScreen
import com.example.uijp.gulaDarah.ui.GulaDarahPage
import com.example.uijp.gulaDarah.ui.InsertPages
import com.example.uijp.konsultasi.DetailDokterUI
import com.example.uijp.konsultasi.ProfilUi
import com.example.uijp.splash.Onboard1
import com.example.uijp.splash.Onboard2
import com.example.uijp.splash.Onboard3
import com.example.uijp.splash.SplashScreen
import com.example.uijp.tracker.TambahMakananScreen
import com.example.uijp.tracker.TrackerGulaScreen
import com.example.uijp.ui.theme.UijpTheme


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            UijpTheme {
                val navController = rememberNavController()
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    MainNavGraph(navController = navController, modifier = Modifier.padding(innerPadding))
                }
            }
        }
    }
}

@Composable
fun MainNavGraph(navController: NavHostController, modifier: Modifier = Modifier) {
    NavHost(navController = navController, startDestination = "splash", modifier = modifier) {
        composable("splash") { SplashScreen(navController) }
        composable("onboard1") { Onboard1(navController) }
        composable("onboard2") { Onboard2(navController) }
        composable("onboard3") { Onboard3(navController) }
        composable("login") { LoginScreen(navController) }
        composable("register") { RegisterScreen(navController) }
        composable("reminder") { ReminderScreen(navController) }
        composable("tambahmakanan") { TambahMakananScreen(navController) }
        composable("LMP") { LaporanMingguanPage(navController) }
        composable("home") {MainNavigation(navController)}
        composable("artikel") { ArtikelScreen(navController)}
        composable("konsultasi") { KonsultasiUi(navController)}
        composable("tracker") { TrackerGulaScreen(navController)}

        composable("guladarah") {
            val viewModel: GulaDarahViewModel = androidx.lifecycle.viewmodel.compose.viewModel()
            GulaDarahPage(navController = navController)
        }

        composable("reward") { KlaimReward(navController) }
        composable("gamifikasi") { GamifikasiUI(navController)}
        composable("profil") { ProfilUi(navController) }
        composable("pilihWaktu") { PilihWaktuUI(navController) }
        composable("pembayaran") { PembayaranUI(navController) }
        composable("notifikasi") { NotifikasiUI(navController) }
        composable("premium") { GetPremiumScreen(navController) }
        composable("premiumPrice") { PremiumPriceScreen(navController) }
        composable("paymentMethod") { PaymentMethodScreen(navController) }
        composable("paymentSuccess") { PaymentSuccessScreen(navController) }

        composable("insert") {
            val viewModel: GulaDarahViewModel = androidx.lifecycle.viewmodel.compose.viewModel()
            InsertPages(viewModel = viewModel, navController = navController)
        }

        composable("datadiri") { PersonalDataScreen(navController) }

        composable("artikel_kategori/{kategoriName}") { backStackEntry ->
            val kategoriName = backStackEntry.arguments?.getString("kategoriName") ?: ""
            ArtikelKategoriScreen(
                navController = navController, // ← ini penting untuk bisa navigasi
                kategoriName = kategoriName
            )
        }

        composable("detail/{judul}") { backStackEntry ->
            val judul = backStackEntry.arguments?.getString("judul") ?: ""
            DetailArtikelScreen(judul = judul, navController = navController)
        }

        composable("detailDokter") {
            DetailDokterUI(navController = navController)
        }
    }
}

