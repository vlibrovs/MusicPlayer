package com.vlibrovs.musicplayer.data.model

import com.vlibrovs.musicplayer.data.model.group.MusicCollection

data class Author(
    val name: String,
    val groups: List<MusicCollection>,
    val tracks: List<Track>,
    val profilePictureUrl: String?
)
