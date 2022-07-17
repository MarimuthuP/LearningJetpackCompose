package com.mrm.learningjetpackcompose.bottomnavanim

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.mrm.learningjetpackcompose.ui.theme.LearningJetpackComposeTheme

class BottomMenuAnimActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            LearningJetpackComposeTheme {
                BottomMainScreen()
            }
        }
    }
}