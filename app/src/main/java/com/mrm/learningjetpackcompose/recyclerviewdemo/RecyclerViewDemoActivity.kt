package com.mrm.learningjetpackcompose.recyclerviewdemo

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.tooling.preview.Preview
import com.mrm.learningjetpackcompose.recyclerviewdemo.data.Puppy
import com.mrm.learningjetpackcompose.ui.theme.LearningJetpackComposeTheme

class RecyclerViewDemoActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            LearningJetpackComposeTheme {
                val context = LocalContext.current
                Column {
                    TopAppBar {
                        Text(
                            text = "RecyclerView with detail view",
                            style = TextStyle(
                                color = Color.White,
                                fontSize = MaterialTheme.typography.h6.fontSize,
                                fontWeight = MaterialTheme.typography.h6.fontWeight
                            )
                        )
                    }
                    PuppyDetails {
                        startActivity(ProfileActivity.newIntent(context = context, it))
                    }
                }
            }
        }
    }
}


@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
fun PuppyDetails(navigateToProfile: (Puppy) -> Unit) {
    Scaffold {
        PuppyHomeContent(navigateToProfile)
    }
}