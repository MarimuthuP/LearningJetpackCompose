package com.mrm.learningjetpackcompose

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun TextSample(){
    SimpleMessage("Everything will be alright!")
}

@Composable
fun SimpleMessage(name: String) {
    Column(modifier = Modifier.fillMaxSize(),
    verticalArrangement = Arrangement.Center,
    horizontalAlignment = Alignment.CenterHorizontally,
    content = {
        simpleTextview(name = name)
        customStyledText(displayText = "At the right moment")
    })
}

@Composable
fun simpleTextview(name: String){
    Text(text = name)
}

@Composable
fun customStyledText(displayText: String, style: TextStyle? = null, maxLines: Int? = null){
    Text(
        text = displayText,
        modifier = Modifier.padding(16.dp),
        style = style ?: TextStyle.Default,
        overflow = TextOverflow.Ellipsis,
        maxLines = maxLines ?: Int.MAX_VALUE
    )
    Divider(color = Color.Gray)
}

@Composable
fun customStyledTextView(displayText: String){
    val shape = RoundedCornerShape(8.dp)
    val shadowElevationPx = with(LocalDensity.current){2.dp.toPx()}
    val backgroundColor = MaterialTheme.colors.primarySurface
    Text(
        text = displayText,
        color = contentColorFor(backgroundColor = backgroundColor),
        modifier = Modifier
            .background(color = backgroundColor, shape = shape)
            .border(1.dp, MaterialTheme.colors.secondary, shape = shape)
            .graphicsLayer(shape = shape, shadowElevation = shadowElevationPx)
            .padding(1.dp)
    )

}

@Preview
@Composable
fun previewSimpleMessage(){
    SimpleMessage(name = "Everything will be alright!")
}

@Preview
@Composable
fun previewCustomStyledText(){
    customStyledText(
        displayText = "Fantastic moment going to arrive",
        maxLines = 2,
        style = TextStyle(
            color = Color.Red,
            fontWeight = FontWeight.W900,
            fontStyle = FontStyle.Italic,
            fontFamily = FontFamily.Cursive,
            fontSize = 20.sp,
            textAlign = TextAlign.Justify
        ))
}

@Preview
@Composable
fun previewCustomStyledTextView(){
    customStyledTextView(displayText = "You will get it soon what you are looking for")
}