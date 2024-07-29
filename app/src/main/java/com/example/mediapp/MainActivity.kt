package com.example.mediapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.rememberNavController
import com.example.mediapp.ui.theme.AppNavigation
import com.example.mediapp.ui.theme.HomeScreen
import com.example.mediapp.ui.theme.MediAppTheme
import com.example.mediapp.ui.theme.ProfileScreen

class MainActivity : ComponentActivity() {
    //@ExperimentalFoundationApi
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MediAppTheme {
                //HomeScreen()
                //ProfileScreen()
                val navController = rememberNavController()
                AppNavigation(navController)
            }
        }
    }
}

