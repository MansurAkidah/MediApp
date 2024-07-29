package com.example.mediapp.ui.theme

import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.scale
import androidx.compose.ui.focus.FocusRequester.Companion.createRefs
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Color.Companion.White
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Constraints
import androidx.compose.ui.unit.dp
import androidx.constraintlayout.widget.ConstraintLayout

import com.example.mediapp.BottomMenuContent
import com.example.mediapp.Feature
import com.example.mediapp.R

@Preview
@Composable
fun ProfileScreen() {
    Box(modifier = Modifier
        .background(DeepBlue)
        .fillMaxSize()
    ){
        Column {
            //IntroSection()
            //HeadSection()
            //FeatureSection()
            profile()
        }
        BottomMenu(items = listOf(
            BottomMenuContent("Home", R.drawable.ic_home),
            BottomMenuContent("Meditate", R.drawable.ic_bubble),
            BottomMenuContent("Sleep", R.drawable.ic_moon),
            BottomMenuContent("Music", R.drawable.ic_music),
            BottomMenuContent("Profile", R.drawable.ic_profile),
        ), modifier = Modifier.align(Alignment.BottomCenter))
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
fun profile(){

}