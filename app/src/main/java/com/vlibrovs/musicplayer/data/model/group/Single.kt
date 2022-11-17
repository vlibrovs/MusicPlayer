package com.vlibrovs.musicplayer.data.model.group

import com.vlibrovs.musicplayer.data.model.Track

data class Single(
    val track: Track,
) : MusicCollection(track.name, track.authorName, null, track.imageUrl)
