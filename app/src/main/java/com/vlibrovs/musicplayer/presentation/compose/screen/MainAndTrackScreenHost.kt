package com.vlibrovs.musicplayer.presentation.compose.screen

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.slideInVertically
import androidx.compose.animation.slideOutVertically
import androidx.compose.material.swipeable
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.vlibrovs.musicplayer.presentation.viewmodel.MainViewModel

@Composable
fun MainAndTrackScreenHost(viewModel: MainViewModel) {
    MainScreen(viewModel = viewModel)
    AnimatedVisibility(
        visible = viewModel.trackScreenVisible,
        enter = slideInVertically { it },
        exit = slideOutVertically { it }
    ) {
        TrackScreen(viewModel = viewModel)
    }
}