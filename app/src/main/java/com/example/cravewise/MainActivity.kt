package com.example.cravewise

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import com.example.cravewise.ui.CraveWiseAppRoot
import com.example.cravewise.ui.theme.CraveWiseTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        enableEdgeToEdge()
        super.onCreate(savedInstanceState)
        setContent {
            CraveWiseTheme {
                CraveWiseAppRoot()
            }
        }
    }
}
