package com.mrm.learningjetpackcompose

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.contentColorFor
import androidx.compose.material.primarySurface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun Home() {
    Greeting(name = "Vanakkam")
}

@Composable
fun Greeting(name: String) {
    val shape = RoundedCornerShape(8.dp)
    val shadowElevationPx = with(LocalDensity.current){2.dp.toPx()}
    val backgroundColor = MaterialTheme.colors.primarySurface
    Text(
        text = "$name Android",
        color = contentColorFor(backgroundColor = backgroundColor),
        modifier = Modifier
            .background(backgroundColor, shape = shape)
            .border(1.dp, MaterialTheme.colors.secondary, shape = shape)
            .graphicsLayer(shape = shape, shadowElevation = shadowElevationPx)
            .padding(8.dp)
    )
}

@Composable
fun sampleTextView(){
    Column(modifier = Modifier.fillMaxSize(),
    verticalArrangement = Arrangement.Center,
    horizontalAlignment = Alignment.CenterHorizontally,
    content = {
        simpleText(name = "Everything comes to you at the right moment")
    })
}

@Composable
fun simpleText(name: String){
    Text(text = name)
}

/* Preview methods started here */

@Preview()
@Composable
fun DefaultPreview() {
    Greeting(name = "Vanakkam")
}

@Preview
@Composable
fun previewSampleTextView(){
    sampleTextView()
}