package com.example.fliproll.navigation

sealed class Screen(val route: String) {
    object Splash : Screen("splash")
    object Choose : Screen("choose")
    object Dice : Screen("dice")
    object Coin : Screen("coin")
}