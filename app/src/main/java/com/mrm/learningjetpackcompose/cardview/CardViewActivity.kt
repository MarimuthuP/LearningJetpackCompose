package com.mrm.learningjetpackcompose.cardview

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.mrm.learningjetpackcompose.R

class CardViewActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Column {
                TopAppBar {
                    Text(
                        text = "CardView with Animation",
                        style = TextStyle(
                            color = Color.White,
                            fontSize = MaterialTheme.typography.h6.fontSize
                        )
                    )
                }
                CardViewWithClickAnimation()
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun CardViewWithClickAnimation() {
    Column(
        modifier = Modifier
            .padding(5.dp)
            .fillMaxSize(),
        verticalArrangement = Arrangement.Center
    ) {
        Spacer(modifier = Modifier.height(10.dp))
        Card(
            modifier = Modifier.padding(16.dp),
            elevation = 4.dp,
            shape = RoundedCornerShape(corner = CornerSize(16.dp))
        ) {
            ContentView()
        }
    }
}

@OptIn(ExperimentalAnimationApi::class)
@Composable
fun ContentView(){
    var expanded by remember { mutableStateOf(false) }
    Column(modifier = Modifier
        .fillMaxWidth()
        .clickable { expanded = !expanded }) {
        Image(
            painter = painterResource(id = R.drawable.secret),
            contentDescription = "",
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .align(Alignment.CenterHorizontally)
                .size(200.dp)
                .padding(10.dp)
                .clip(CircleShape)
        )

        AnimatedVisibility(expanded) {
            Text(
                text = "Jetpack Compose",
                style = MaterialTheme.typography.h2,
                textAlign = TextAlign.Center,
                modifier = Modifier
                    .padding(10.dp)
                    .fillMaxWidth()
                    .align(Alignment.CenterHorizontally)

            )
        }
    }
}