package com.vlibrovs.musicplayer.data.model.group

import com.vlibrovs.musicplayer.data.model.Track

data class Album(
    override val name: String,
    override val authorName: String,
    override val description: String? = null,
    val tracks: List<Track>,
    override val imageUrl: String?
) : MusicCollection(name, authorName, description, imageUrl)