package com.example.mediapp

sealed class Screen(val route: String) {
    object Home : Screen("home")
    object Meditate : Screen("meditate")
    object Sleep : Screen("sleep")
    object Music : Screen("profile") // Using "profile" route for music as well
    object Profile : Screen("profile")
    object Video : Screen("video/{uri}")
}