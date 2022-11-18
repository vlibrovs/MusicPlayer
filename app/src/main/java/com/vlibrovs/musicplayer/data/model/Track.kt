package com.vlibrovs.musicplayer.data.model

data class Track(
    val name: String,
    val authorName: String,
    val imageUrl: String?,
    val musicUrl: String,
    val secondsLong: Int
) {
    companion object {
        val Empty = Track(
            name = "Empty",
            authorName = "Empty",
            imageUrl = null,
            musicUrl = "",
            secondsLong = 0
        )
    }
}

typealias Playlist = List<Track>
typealias MutablePlaylist = MutableList<Track>
