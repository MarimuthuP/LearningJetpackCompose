package com.mrm.learningjetpackcompose.bottomnavmenu

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent

class BottomNavMenuActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MainScreen()
        }
    }
}