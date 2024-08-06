package com.example.mediapp

sealed class Screen(val route: String) {
    object Home : Screen("Home")
    object Meditate : Screen("Meditate")
    object Sleep : Screen("Sleep")
    object Music : Screen("Music") // Using "profile" route for music as well
    object Profile : Screen("Profile")
    object Video : Screen("video/{uri}")
}