package com.example.fliproll

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.SideEffect
import androidx.compose.ui.graphics.luminance
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.fliproll.navigation.Screen
import com.google.accompanist.systemuicontroller.rememberSystemUiController
import com.example.fliproll.ui.theme.FlipRollTheme
import com.example.fliproll.uiscreens.CoinScreen
import com.example.fliproll.uiscreens.DiceScreen
import com.example.fliproll.uiscreens.ModeSelectionScreen
import com.example.fliproll.uiscreens.SplashScreen

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            FlipRollTheme {
                FlipRoll()
            }
        }
    }
}


@Composable
fun FlipRoll() {
    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = Screen.Splash.route) {
        composable(Screen.Splash.route) {
            SplashScreen(navController)
        }
        composable(Screen.Choose.route) {
            ModeSelectionScreen(navController)
        }
        composable(Screen.Dice.route) {
            DiceScreen()
        }
        composable(Screen.Coin.route) {
            CoinScreen()
        }
    }
}



