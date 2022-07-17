package com.mrm.learningjetpackcompose.composewithxml

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.mrm.learningjetpackcompose.R

class FirstActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_first)

        supportFragmentManager
            .beginTransaction()
            .add(R.id.content, FirstFragment())
            .commit()
    }
}