package com.vlibrovs.musicplayer.data.model

data class Track(
    val name: String,
    val authorName: String,
    val collectionType: CollectionType = CollectionType.Single,
    val imageUrl: String?,
    val musicUrl: String
) {
    companion object {
        val Empty = Track(
            name = "Empty",
            authorName = "Empty",
            imageUrl = null,
            musicUrl = ""
        )
    }
}

typealias Playlist = List<Track>
typealias MutablePlaylist = MutableList<Track>

sealed class CollectionType {
    object Single : CollectionType()
    data class Album(val name: String) : CollectionType()
}
