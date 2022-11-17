package com.vlibrovs.musicplayer.data.model

data class Track(
    val name: String,
    val authorName: String,
    val collectionType: CollectionType,
    val imageUrl: String?,
    val musicUrl: String
)

typealias Playlist = List<Track>

sealed class CollectionType {
    object Single : CollectionType()
    data class Album(val name: String) : CollectionType()
}
