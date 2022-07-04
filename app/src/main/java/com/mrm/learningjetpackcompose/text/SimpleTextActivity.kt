package com.mrm.learningjetpackcompose.text

import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.mrm.learningjetpackcompose.R

class SimpleTextActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Column(
                modifier = Modifier
                    .padding(10.dp)
                    .fillMaxSize()
                    .wrapContentSize()
                    .fillMaxHeight(),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                SimpleText(displayText = "This is simple textview")
                Text(text = "Vaazhga valamudan!")
            }
        }
    }
}


@Composable
fun SimpleText(displayText: String) {
    val context = LocalContext.current
    Text(
        text = displayText,
        fontSize = 35.sp,
        color = colorResource(id = R.color.purple_700),
        fontFamily = FontFamily.Cursive,
        modifier = Modifier
            .padding(10.dp)
            .clickable {
                Toast
                    .makeText(context, "View Clicked", Toast.LENGTH_LONG)
                    .show()
            }
    )
}

@Preview(showBackground = true)
@Composable
fun SimpleTextViewPreview() {
    Column(
        modifier = Modifier
            .padding(10.dp)
            .fillMaxSize()
            .wrapContentSize()
            .fillMaxHeight(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        SimpleText(displayText = "This is simple textview")
        Text(text = "Vaazhga valamudan!")
    }
}
