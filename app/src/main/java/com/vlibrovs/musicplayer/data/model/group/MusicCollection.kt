package com.vlibrovs.musicplayer.data.model.group

abstract class MusicCollection(
    open val name: String,
    open val authorName: String,
    open val description: String? = null,
    open val imageUrl: String?
)