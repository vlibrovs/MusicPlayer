package com.vlibrovs.musicplayer.data.model

data class Author(
    val name: String,
    val tracks: List<Track>,
    val profilePictureUrl: String?
)
