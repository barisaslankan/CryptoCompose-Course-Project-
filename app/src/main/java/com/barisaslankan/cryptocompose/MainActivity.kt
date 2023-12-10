package com.barisaslankan.cryptocompose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.barisaslankan.cryptocompose.ui.theme.CryptoComposeTheme
import com.barisaslankan.cryptocompose.view.CryptoDetailsScreen
import com.barisaslankan.cryptocompose.view.CryptoListScreen
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {

            CryptoComposeTheme {

                val navController = rememberNavController()

                NavHost(navController = navController, startDestination = "crypto_list_screen" ){

                    composable("crypto_list_screen"){

                        CryptoListScreen(navController = navController)
                    }

                    composable("crypto_details_screen/{cryptoID}/{cryptoPrice}", arguments = listOf(
                        navArgument("cryptoID"){
                            type = NavType.StringType
                        },
                        navArgument("cryptoPrice"){
                            type = NavType.StringType
                        }
                    )){

                        val cryptoID = remember {
                            it.arguments?.getString("cryptoID")
                        }

                        val cryptoPrice = remember{
                            it.arguments?.getString("cryptoPrice")
                        }

                        CryptoDetailsScreen(id = cryptoID ?: "", price = cryptoPrice ?: "", navController = navController)

                    }
                }
            }
        }
    }
}
