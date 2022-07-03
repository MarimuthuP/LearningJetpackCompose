package com.mrm.learningjetpackcompose.text

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
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
import com.mrm.learningjetpackcompose.TextViewCollection

class CustomStyledTextActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Column(modifier = Modifier.fillMaxSize(),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally,
                content = {
                    roundedCornerTextView(name = "Hello")
                    customStyledText(displayText = "This is a custom style text")
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
                        ),
                        isBorder = true
                    )
                })
        }
    }
}

@Composable
fun roundedCornerTextView(name: String){
    //Text(text = name)
    val shape = RoundedCornerShape(8.dp)
    val shadowElevationPx = with(LocalDensity.current){2.dp.toPx()}
    val backgroundColor = MaterialTheme.colors.primarySurface
    Text(
        text = "$name Android!",
        color = contentColorFor(backgroundColor = backgroundColor),
        modifier = Modifier
            .background(backgroundColor, shape = shape)
            .border(1.dp, MaterialTheme.colors.secondary, shape = shape)
            .graphicsLayer(shape = shape, shadowElevation = shadowElevationPx)
            .padding(8.dp)
    )
}

@Composable
fun customStyledText(
    displayText: String,
    style: TextStyle? = null,
    maxLines: Int? = null,
    isBorder: Boolean = false
){
    Text(
        text = displayText,
        modifier = Modifier.padding(16.dp),
        style = style ?: TextStyle.Default,
        overflow = TextOverflow.Ellipsis,
        maxLines = maxLines ?: Int.MAX_VALUE
    )

    if(isBorder)
        Divider(color = Color.Gray)
}


/* Preview methods started here */
@Preview
@Composable
fun previewSampleTextView(){
    TextViewCollection()
}