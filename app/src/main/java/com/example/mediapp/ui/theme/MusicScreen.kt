package com.example.mediapp.ui.theme

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import com.example.mediapp.BottomMenuContent
import com.example.mediapp.R

@Composable
fun MusicScreen(navController: NavController) {
    Box(modifier = Modifier
        .background(DeepBlue)
        .fillMaxSize()
    ){
        Column {
            Text(text = "Music Screen")
        }
        BottomMenu(items = listOf(
            BottomMenuContent("Home", R.drawable.ic_home),
            BottomMenuContent("Meditate", R.drawable.ic_bubble),
            BottomMenuContent("Sleep", R.drawable.ic_moon),
            BottomMenuContent("Music", R.drawable.ic_music),
            BottomMenuContent("Profile", R.drawable.ic_profile),
        ), modifier = Modifier.align(Alignment.BottomCenter),
            onItemClick = { screen -> navController.navigate(screen.route)})
    }
}
