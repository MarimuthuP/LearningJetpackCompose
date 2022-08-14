package com.mrm.learningjetpackcompose.composewithxml

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.TextView
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.viewinterop.AndroidView
import com.mrm.learningjetpackcompose.R

class DemoActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ComposeWithXML()
        }
    }
}

@Composable
fun ComposeWithXML(){
    AndroidView(factory = {
        View.inflate(it, R.layout.demo_layout, null)
    }, modifier = Modifier.fillMaxSize(),
    update = {
        val textView = it.findViewById<TextView>(R.id.tv_title)
        textView.setOnClickListener {
            textView.text = "Be Patient!"
        }
    })
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview(){
    Surface(modifier = Modifier.fillMaxSize()) {
        ComposeWithXML()
    }
}