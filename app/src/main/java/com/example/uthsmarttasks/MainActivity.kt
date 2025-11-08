package com.example.uthsmarttasks

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.ui.Modifier
import com.example.uthsmarttasks.navigation.NavGraph

import com.example.uthsmarttasks.ui.theme.UthsmarttasksTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            UthsmarttasksTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->

                   NavGraph(modifier = Modifier.padding(innerPadding))


                }
            }
        }
    }
}
