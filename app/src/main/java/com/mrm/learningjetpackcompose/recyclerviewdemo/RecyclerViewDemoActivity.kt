package com.mrm.learningjetpackcompose.recyclerviewdemo

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.mrm.learningjetpackcompose.recyclerviewdemo.data.Puppy
import com.mrm.learningjetpackcompose.ui.theme.LearningJetpackComposeTheme

class RecyclerViewDemoActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            LearningJetpackComposeTheme {
                PuppyDetails {
                    startActivity(ProfileActivity.newIntent(this, it))
                }
            }
        }
    }
}


@Composable
fun PuppyDetails(navigateToProfile: (Puppy) -> Unit) {
    Scaffold {
        PuppyHomeContent(navigateToProfile)
    }
}