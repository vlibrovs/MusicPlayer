package com.vlibrovs.musicplayer.data.remote

import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase
import com.vlibrovs.musicplayer.data.model.Song
import com.vlibrovs.musicplayer.util.values.Constants.SONG_COLLECTION_PATH
import kotlinx.coroutines.tasks.await

class MusicDatabase {
    private val firestore = Firebase.firestore
    private val songCollection = firestore.collection(SONG_COLLECTION_PATH)

    suspend fun getAllSongs(): List<Song> {
        return try {
            songCollection.get().await().toObjects(Song::class.java)
        } catch (e: Exception) {
            emptyList()
        }
    }

}