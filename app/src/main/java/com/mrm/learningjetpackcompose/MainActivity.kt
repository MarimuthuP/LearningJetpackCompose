package com.mrm.learningjetpackcompose

import android.content.Intent
import android.os.Bundle
import android.view.Gravity
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.primarySurface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.mrm.learningjetpackcompose.image.ImageActivity
import com.mrm.learningjetpackcompose.text.SimpleTextActivity
import com.mrm.learningjetpackcompose.ui.theme.LearningJetpackComposeTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Column(
                modifier = Modifier.fillMaxSize(),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                TitleForTextView(title = "Simple TextView")
                TitleForImageView(title = "Cardview with image and button")
            }
        }
    }
}

@Composable
fun TitleForTextView(title: String){

    val context = LocalContext.current
    val shape = RoundedCornerShape(8.dp)
    val shadowElevationPx = with(LocalDensity.current){2.dp.toPx()}
    val backgroundColor = MaterialTheme.colors.primarySurface

    Text(
        text = title,
        fontSize = 20.sp,
        textAlign = TextAlign.Center,
        color = Color.White,
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp)
            .border(1.dp, MaterialTheme.colors.secondary, shape = shape)
            .graphicsLayer(shape = shape, shadowElevation = shadowElevationPx)
            .background(backgroundColor, shape = shape)
            .padding(10.dp)
            .clickable {
                context.startActivity(Intent(context, SimpleTextActivity::class.java))
            }
    )
}

@Composable
fun TitleForImageView(title: String){

    val context = LocalContext.current
    val shape = RoundedCornerShape(8.dp)
    val shadowElevationPx = with(LocalDensity.current){2.dp.toPx()}
    val backgroundColor = MaterialTheme.colors.primarySurface

    Text(
        text = title,
        fontSize = 20.sp,
        textAlign = TextAlign.Center,
        color = Color.White,
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp)
            .border(1.dp, MaterialTheme.colors.secondary, shape = shape)
            .graphicsLayer(shape = shape, shadowElevation = shadowElevationPx)
            .background(backgroundColor, shape = shape)
            .padding(10.dp)
            .clickable {
                context.startActivity(Intent(context, ImageActivity::class.java))
            }
    )
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    LearningJetpackComposeTheme {
        Column(
            modifier = Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            TitleForTextView("Vanakkam")
            TitleForImageView(title = "Image")
        }
    }
}


/*
* setContent {
            LearningJetpackComposeTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    TextViewCollection()
                    //TextSample()
                    //ClickableText()
                    //BookDetails()
                }
            }
        }
* */

/*
Surface(modifier = Modifier
.fillMaxSize()
.fillMaxWidth()) {
    TextViewCollection()
}*/
