package com.example.mediapp

import android.media.MediaPlayer
import androidx.annotation.DrawableRes
import androidx.annotation.RawRes
import androidx.compose.ui.graphics.Color
import java.net.URL

data class Audios(
    @RawRes val file: Int,
    //val mediaPlayer: MediaPlayer,
    val title: String,
    @DrawableRes val iconId: Int,//drawable resource
    val lightColor: Color,
    val mediumColor: Color,
    val darkColor: Color
)
