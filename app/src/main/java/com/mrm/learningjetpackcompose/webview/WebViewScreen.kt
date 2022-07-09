package com.mrm.learningjetpackcompose.webview

import android.graphics.Bitmap
import android.util.Log
import android.webkit.WebView
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.dp
import com.google.accompanist.web.*

@Composable
fun WebViewScreen() {
    var url by remember { mutableStateOf("https://www.google.com/") }
    var state = rememberWebViewState(url = url)
    var navigator = rememberWebViewNavigator()
    var textAddressField by remember(state.content.getCurrentUrl()) {
        mutableStateOf(state.content.getCurrentUrl() ?: "")
    }

    Column {
        TopAppBar {
            IconButton(onClick = { navigator.navigateBack() }) {
                Icon(imageVector = Icons.Default.ArrowBack, contentDescription = "Back")
            }
            IconButton(onClick = { navigator.navigateForward() }) {
                Icon(imageVector = Icons.Default.ArrowForward, contentDescription = "Forward")
            }
            Text(
                text = "Web Browser",
                style = TextStyle(
                    color = Color.White,
                    fontSize = MaterialTheme.typography.h6.fontSize,
                    fontWeight = MaterialTheme.typography.h6.fontWeight
                )
            )
            Row(modifier = Modifier.weight(1f), horizontalArrangement = Arrangement.End) {
                IconButton(onClick = { navigator.reload() }) {
                    Icon(imageVector = Icons.Default.Refresh, contentDescription = "Refresh")
                }

                IconButton(onClick = { url = textAddressField }) {
                    Icon(imageVector = Icons.Default.Check, contentDescription = "Go")
                }
            }
        }

        Row(modifier = Modifier.padding(12.dp)) {
            BasicTextField(
                modifier = Modifier.weight(9f),
                value = textAddressField,
                onValueChange = { textAddressField = it },
                maxLines = 1
            )
            if (state.errorsForCurrentRequest.isNotEmpty()) {
                Icon(
                    modifier = Modifier.weight(1f),
                    imageVector = Icons.Default.Warning,
                    contentDescription = "Error",
                    tint = Color.Red
                )
            }
        }

        val loadingState = state.loadingState
        if (loadingState is LoadingState.Loading) {
            LinearProgressIndicator(
                progress = loadingState.progress,
                modifier = Modifier.fillMaxWidth()
            )
        }

        val webClient = remember {
            object : AccompanistWebViewClient() {
                override fun onPageStarted(view: WebView?, url: String?, favicon: Bitmap?) {
                    super.onPageStarted(view, url, favicon)
                    Log.d("Accompanist webview", "Page started $url")
                }
            }
        }

        WebView(
            state = state,
            navigator = navigator,
            onCreated = { webView -> webView.settings.javaScriptEnabled = true },
            client = webClient
        )
    }
}