package com.example.techtask.ui

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.ui.Modifier
import com.example.techtask.ui.screens.MainScreen
import com.example.techtask.ui.theme.TechTaskTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            TechTaskTheme {
                Surface(modifier = Modifier.fillMaxSize(), color = MaterialTheme.colors.background) {
                    MainScreen()
                }
            }
        }
    }
}