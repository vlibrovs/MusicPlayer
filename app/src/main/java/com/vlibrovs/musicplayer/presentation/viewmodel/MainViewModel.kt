package com.vlibrovs.musicplayer.presentation.viewmodel

import androidx.compose.runtime.*
import androidx.lifecycle.ViewModel
import com.vlibrovs.musicplayer.data.model.Playlist
import com.vlibrovs.musicplayer.data.model.Track

class MainViewModel : ViewModel() {
    private val _playlist = mutableStateListOf<Track>(
        Track(
            name = "Stressed Out",
            authorName = "Twenty One Pilots",
            imageUrl = null,
            musicUrl = ""
        ),
        Track(
            name = "Shape of You",
            authorName = "Ed Sheeran",
            imageUrl = null,
            musicUrl = ""
        ),
        Track(
            name = "Believer",
            authorName = "Imagine Dragons",
            imageUrl = null,
            musicUrl = ""
        ),
        Track(
            name = "Demons",
            authorName = "Imagine Dragons",
            imageUrl = null,
            musicUrl = ""
        )
    )

    val playlist: Playlist get() = _playlist

    var bottomPlayerVisible by mutableStateOf(false)
        private set

    var playingTrack by mutableStateOf<Track?>(null)
        private set

    var playingTrackNumber by mutableStateOf<Int?>(null)
        private set

    var musicPlaying by mutableStateOf(false)
        private set

    fun resume() {
        musicPlaying = true
    }

    fun pause() {
        musicPlaying = false
    }

    fun playTrackByIndex(index: Int) {
        playingTrackNumber = index
        playingTrack = playlist[index]
        if (!bottomPlayerVisible) bottomPlayerVisible = true
    }
}
