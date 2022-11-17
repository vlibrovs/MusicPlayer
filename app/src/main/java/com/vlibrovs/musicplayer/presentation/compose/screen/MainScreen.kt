package com.vlibrovs.musicplayer.presentation.compose.screen

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.vlibrovs.musicplayer.presentation.compose.theme.AppTheme

@Composable
fun MainScreen() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(color = MaterialTheme.colors.background)
    ) {
        
    }
}

@Preview
@Composable
fun MusicListScreenPreview() {
    AppTheme {
        MainScreen()
    }
}
