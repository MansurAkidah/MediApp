package com.example.mediapp.ui.theme

import android.media.MediaPlayer
import android.net.Uri
import androidx.compose.foundation.*
import androidx.compose.foundation.gestures.scrollable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.GridCells
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.LazyVerticalGrid
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.scale
import androidx.compose.ui.focus.FocusRequester.Companion.createRefs
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Color.Companion.White
import androidx.compose.ui.graphics.Path
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Constraints
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.navigation.NavController
import com.example.mediapp.*
import com.example.mediapp.R
import com.google.android.exoplayer2.upstream.RawResourceDataSource
import com.google.android.exoplayer2.util.Log

@Composable
fun ProfileScreen(navController: NavController) {
    val context = LocalContext.current
    var isPlaying by remember { mutableStateOf(false) }
    var currentMediaPlayer by remember { mutableStateOf<MediaPlayer?>(null) }

    Box(modifier = Modifier
        .background(DeepBlue)
        .fillMaxSize()
    ) {
        Column(modifier = Modifier.verticalScroll(rememberScrollState())) {
            SongsSection(
                songs = listOf(
                    Audios(R.raw.haha, "Haha by juice", R.drawable.ic_headphone, BlueViolet1, BlueViolet2, BlueViolet1),
                    Audios(R.raw.charming, "Charming by juice", R.drawable.ic_headphone, LightGreen1, LightGreen2, LightGreen3),
                    Audios(R.raw.setmefree, "Set Me Free by juice", R.drawable.ic_headphone, OrangeYellow1, OrangeYellow2, OrangeYellow3),
                    Audios(R.raw.naruto, "Naruto by juice", R.drawable.ic_headphone, Beige1, Beige2, Beige3),
                    Audios(R.raw.yesterday, "Yesterday by juice", R.drawable.ic_headphone, BlueViolet1, BlueViolet2, BlueViolet3),
                    Audios(R.raw.charming, "Charming2 by juice", R.drawable.ic_headphone, LightGreen1, LightGreen2, LightGreen3),
                    Audios(R.raw.medi, "Medi by juice", R.drawable.ic_headphone, Beige1, Beige2, Beige3),
                    Audios(R.raw.naruto, "Naruto by juice", R.drawable.ic_headphone, BlueViolet1, BlueViolet2, BlueViolet3)
                ),
                onFeatureClick = { audio ->
                    currentMediaPlayer?.apply {
                        if (isPlaying) {
                            pause()
                            release()
                        } else {
                            release()
                            currentMediaPlayer = MediaPlayer.create(context, audio.file).apply {
                                start()
                                setOnCompletionListener {
                                    isPlaying = false
                                }
                            }
                        }
                        isPlaying = !isPlaying
                    } ?: run {
                        currentMediaPlayer?.release()
                        currentMediaPlayer = MediaPlayer.create(context, audio.file).apply {
                            start()
                            setOnCompletionListener {
                                isPlaying = false
                            }
                        }
                        isPlaying = true
                    }
                }
            )

            profile(
                audios = listOf(
                    Audios(R.raw.haha, "Haha by juice", R.drawable.ic_headphone, BlueViolet1, BlueViolet2, BlueViolet1),
                    Audios(R.raw.charming, "Charming by juice", R.drawable.ic_headphone, LightGreen1, LightGreen2, LightGreen3),
                    Audios(R.raw.setmefree, "Set Me Free by juice", R.drawable.ic_headphone, OrangeYellow1, OrangeYellow2, OrangeYellow3),
                    Audios(R.raw.naruto, "Naruto by juice", R.drawable.ic_headphone, Beige1, Beige2, Beige3),
                    Audios(R.raw.yesterday, "Yesterday by juice", R.drawable.ic_headphone, BlueViolet1, BlueViolet2, BlueViolet3),
                    Audios(R.raw.charming, "Charming2 by juice", R.drawable.ic_headphone, LightGreen1, LightGreen2, LightGreen3),
                    Audios(R.raw.medi, "Medi by juice", R.drawable.ic_headphone, Beige1, Beige2, Beige3),
                    Audios(R.raw.naruto, "Naruto by juice", R.drawable.ic_headphone, BlueViolet1, BlueViolet2, BlueViolet3)
                ),
                onFeatureClick = { audio ->
                    currentMediaPlayer?.apply {
                        if (isPlaying) {
                            pause()
                            release()
                        } else {
                            release()
                            currentMediaPlayer = MediaPlayer.create(context, audio.file).apply {
                                start()
                                setOnCompletionListener {
                                    isPlaying = false
                                }
                            }
                        }
                        isPlaying = !isPlaying
                    } ?: run {
                        currentMediaPlayer?.release()
                        currentMediaPlayer = MediaPlayer.create(context, audio.file).apply {
                            start()
                            setOnCompletionListener {
                                isPlaying = false
                            }
                        }
                        isPlaying = true
                    }
                }
            )
        }

        BottomMenu(
            items = listOf(
                BottomMenuContent("Home", R.drawable.ic_home),
                BottomMenuContent("Meditate", R.drawable.ic_bubble),
                BottomMenuContent("Sleep", R.drawable.ic_moon),
                BottomMenuContent("Music", R.drawable.ic_music),
                BottomMenuContent("Profile", R.drawable.ic_profile)
            ),
            modifier = Modifier.align(Alignment.BottomCenter),
            onItemClick = { screen -> navController.navigate(screen.route) }
        )
    }

    DisposableEffect(Unit) {
        onDispose {
            currentMediaPlayer?.release()
        }
    }
}
@OptIn(ExperimentalFoundationApi::class)
@Composable
fun profile(audios: List<Audios>, onFeatureClick: (Audios) -> Unit, color: Color = LightRed) {
    Column(modifier = Modifier.fillMaxWidth()) {
        Text(
            text = "Songs",
            style = MaterialTheme.typography.headlineLarge,
            modifier = Modifier.padding(15.dp)
        )
        LazyVerticalGrid(
            cells = GridCells.Fixed(2),
            contentPadding = PaddingValues(start = 7.5.dp, end = 7.5.dp, bottom = 100.dp),
            modifier = Modifier.fillMaxHeight()
        ) {
            items(audios.size) {
                Songs(audios = audios[it], onFeatureClick = onFeatureClick)
            }
        }
    }
}
@Composable
fun Songs(audios: Audios, onFeatureClick: (Audios) -> Unit, color: Color = LightRed){
    BoxWithConstraints(modifier = Modifier
        .padding(3.dp)
        .aspectRatio(3.7f)
        .clip(RoundedCornerShape(10.dp))
        .background(audios.darkColor)
        //.clickable { onFeatureClick(audios) }
    ) {
        val width = constraints.maxWidth
        val height = constraints.maxHeight
        var isPlaying by remember { mutableStateOf(false) }

        // Medium colored path
        val mediumColoredPoint1 = Offset(0f, height * 0.3f)
        val mediumColoredPoint2 = Offset(width * 0.1f, height * 0.35f)
        val mediumColoredPoint3 = Offset(width * 0.4f, height * 0.05f)
        val mediumColoredPoint4 = Offset(width * 0.75f, height * 0.7f)
        val mediumColoredPoint5 = Offset(width * 1.4f, -height.toFloat())

        val mediumColoredPath = Path().apply {
            moveTo(mediumColoredPoint1.x, mediumColoredPoint1.y)
            standardQuadFromTo(mediumColoredPoint1, mediumColoredPoint2)
            standardQuadFromTo(mediumColoredPoint2, mediumColoredPoint3)
            standardQuadFromTo(mediumColoredPoint3, mediumColoredPoint4)
            standardQuadFromTo(mediumColoredPoint4, mediumColoredPoint5)
            lineTo(width.toFloat() + 100f, height.toFloat() + 100f)
            lineTo(-100f, height.toFloat() + 100f)
            close()
        }
        // Light colored path
        val lightPoint1 = Offset(0f, height * 0.35f)
        val lightPoint2 = Offset(width * 0.1f, height * 0.4f)
        val lightPoint3 = Offset(width * 0.3f, height * 0.35f)
        val lightPoint4 = Offset(width * 0.65f, height.toFloat())
        val lightPoint5 = Offset(width * 1.4f, -height.toFloat() / 3f)

        val lightColoredPath = Path().apply {
            moveTo(lightPoint1.x, lightPoint1.y)
            standardQuadFromTo(lightPoint1, lightPoint2)
            standardQuadFromTo(lightPoint2, lightPoint3)
            standardQuadFromTo(lightPoint3, lightPoint4)
            standardQuadFromTo(lightPoint4, lightPoint5)
            lineTo(width.toFloat() + 100f, height.toFloat() + 100f)
            lineTo(-100f, height.toFloat() + 100f)
            close()
        }
        Canvas(
            modifier = Modifier
                .fillMaxSize()
        ) {
            drawPath(
                path = mediumColoredPath,
                color = audios.mediumColor
            )
            drawPath(
                path = lightColoredPath,
                color = audios.lightColor
            )
        }
//        Box(
//            modifier = Modifier
//                .fillMaxSize()
//                .padding(15.dp)
//        ) {
//            Text(
//                text = audios.title,
//                style = MaterialTheme.typography.headlineMedium,
//                lineHeight = 26.sp,
//                modifier = Modifier.align(Alignment.TopStart)
//            )
//            Icon(
//                painter = painterResource(id = audios.iconId),
//                contentDescription = audios.title,
//                tint = Color.White,
//                modifier = Modifier.align(Alignment.BottomStart)
//            )
//            Text(
//                text = "Start",
//                color = TextWhite,
//                fontSize = 14.sp,
//                fontWeight = FontWeight.Bold,
//                modifier = Modifier
////                    .clickable {
////                        // Handle the click
////                    }
//                    .align(Alignment.BottomEnd)
//                    .clip(RoundedCornerShape(10.dp))
//                    .background(ButtonBlue)
//                    .padding(vertical = 6.dp, horizontal = 15.dp)
//            )
//        }


        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween,
            modifier = Modifier
                .padding(15.dp)
                .clip(RoundedCornerShape(10.dp))
                .background(color)
                .padding(horizontal = 15.dp, vertical = 15.dp)
                .fillMaxWidth()
        ) {
            Column {
                Text(
                    text = audios.title,//"Just Listen",
                    style = MaterialTheme.typography.headlineMedium
                )
                Text(
                    text = "Tulia, bado inaundwa. Haina haraka",
                    style = MaterialTheme.typography.bodyMedium,
                    color = TextWhite
                )
            }
            Box(
                contentAlignment = Alignment.Center,
                modifier = Modifier
                    .size(40.dp)
                    .clip(CircleShape)
                    .background(ButtonBlue)
                    .padding(10.dp)
                    .clickable {
                        onFeatureClick(audios)

                        isPlaying = !isPlaying
                    }
            ) {
                Icon(
                    //painter = painterResource( R.drawable.ic_play ),
                    painter = painterResource(id = if (isPlaying) R.drawable.ic_pause else R.drawable.ic_play),
                    //contentDescription = "Play",
                    contentDescription = if (isPlaying) "Pause" else "Play",
                    tint = Color.White,
                    modifier = Modifier.size(16.dp)
                )
            }
        }
    }
}

@Composable
fun HeaderSection(
){
    Row(

        horizontalArrangement = Arrangement.Center,
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier
            .fillMaxWidth()
            .padding(50.dp)
            .padding(start = 30.dp)

    ) {
        Column(
            verticalArrangement = Arrangement.Center
        ) {
            Icon(painter = painterResource(id = R.drawable.ic_search) , contentDescription = "Theme",
                tint = Color.White, modifier = Modifier.size(12.dp)
            )

            Icon(painter = painterResource(id = R.drawable.ic_moon) , contentDescription = "Theme",
            tint = Color.White, modifier = Modifier.size(12.dp)
            )
        }
    }
}


@Composable
fun IntroSection(
    name: String = "Akidah"
) {
    Column(
        //verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier
            .fillMaxWidth()
    ) {
        Row(
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier.padding(start = 10.dp, end = 10.dp)
        ) {
            Box(

                modifier = Modifier
                    .padding(start = 30.dp, end = 30.dp, top = 15.dp, bottom = 10.dp)

            ) {
                Text(
                    text = "Hi, $name",
                    color = Color.White
                )
            }
        }
    }
}


@Composable
fun HeadSection(
    color: Color = LightGreen3,
    color2:Color = BlueViolet2,
    //onClick: () -> Unit
) {
//    Row(modifier = Modifier
//        .padding(15.dp)
//        .clip(RoundedCornerShape(25.dp))
//        .background(color2)
//        .fillMaxWidth()
////        .clickable {
////            onClick()
////        }
//    ) {
        Column(

            modifier = Modifier
                .fillMaxWidth()
        ) {
            Row (
                modifier = Modifier
                    .padding(15.dp)
                    .clip(CircleShape)
                    //.clickable (onClick = onClick)
                    .padding(start = 15.dp)
            )
            {

                Image(
                    painter = painterResource(id = R.drawable.profile_image), // Replace with your image resource
                    contentDescription = null, // Provide an appropriate description for accessibility
                    contentScale = ContentScale.Crop,
                    modifier = Modifier
                        .size(85.dp)
                        .clip(CircleShape)
                        .border(2.dp, Color.Magenta, CircleShape)
                )
                Text(
                    text = "Hifz",
                    style = MaterialTheme.typography.bodyMedium,
                    modifier = Modifier
                        .padding(10.dp)
                )
            }
        }
    }
//}
@Composable
fun SongsSection(songs: List<Audios>,onFeatureClick: (Audios) -> Unit,color: Color = LightRed){
    var selectedSongIndex by remember {
        mutableStateOf(0)
    }
    Column(modifier = Modifier.fillMaxWidth()) {
        Text(
            text = "Songs",
            style = MaterialTheme.typography.headlineLarge,
            modifier = Modifier.padding(5.dp)
        )
        LazyColumn{
            items(songs.size) {
                Songs(audios = songs[it], onFeatureClick = onFeatureClick)
            }
        }

    }
}
