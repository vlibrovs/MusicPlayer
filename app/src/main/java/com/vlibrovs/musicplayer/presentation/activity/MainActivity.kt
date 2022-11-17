package com.vlibrovs.musicplayer.presentation.activity

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.vlibrovs.musicplayer.presentation.compose.screen.MainScreen
import com.vlibrovs.musicplayer.presentation.compose.theme.AppTheme
import com.vlibrovs.musicplayer.presentation.viewmodel.MainViewModel
import org.koin.androidx.viewmodel.ext.android.viewModel

class MainActivity : ComponentActivity() {

    private val mainViewModel: MainViewModel by viewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            AppTheme {
                MainScreen(viewModel = mainViewModel)
            }
        }
    }
}