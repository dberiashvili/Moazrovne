package com.dberiashvili.moazrovne.ui

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.dberiashvili.moazrovne.ui.theme.MoazrovneTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MoazrovneTheme {
               MoazrovneApp()
            }
        }
    }
}

