package com.vlibrovs.musicplayer.presentation.viewmodel

import androidx.compose.runtime.*
import androidx.lifecycle.ViewModel
import com.vlibrovs.musicplayer.data.model.Song

class MainViewModel : ViewModel() {
    private val _playlist = mutableStateListOf<Song>()
    val playlist: List<Song> get() = _playlist

    var trackScreenVisible by mutableStateOf(false)
        private set

    var bottomPlayerVisible by mutableStateOf(false)
        private set

    var playingTrack by mutableStateOf<Song?>(null)
        private set

    var playingTrackNumber by mutableStateOf<Int?>(null)
        private set

    var musicPlaying by mutableStateOf(false)
        private set

    var playerBarProgress by mutableStateOf(0f)
        private set

    val onPlayerBarProgressChange = { progress: Float ->
        playerBarProgress = progress
    }

    fun showTrackScreen() {
        trackScreenVisible = true
    }

    fun hideTrackScreen() {
        trackScreenVisible = false
    }

    fun shuffle() {
        // TODO Implement
    }

    fun playPrevious() {
        // TODO Implement
    }

    fun playNext() {
        // TODO Implement
    }

    fun repeatOne() {
        // TODO Implement
    }

    fun resume() {
        musicPlaying = true
    }

    fun pause() {
        musicPlaying = false
    }

    fun playTrackByIndex(index: Int) {
        playingTrackNumber = index
        playingTrack = playlist[index]
        musicPlaying = true
        if (!bottomPlayerVisible) bottomPlayerVisible = true
    }
}
