package com.vlibrovs.musicplayer.di

import com.google.android.exoplayer2.C
import com.google.android.exoplayer2.ExoPlayer
import com.google.android.exoplayer2.SimpleExoPlayer
import com.google.android.exoplayer2.audio.AudioAttributes
import com.google.android.exoplayer2.upstream.DefaultDataSource
import com.vlibrovs.musicplayer.presentation.service.MusicService
import com.vlibrovs.musicplayer.presentation.viewmodel.MainViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val appModule = module {
    viewModel {
        MainViewModel()
    }
    single {
        AudioAttributes.Builder()
            .setContentType(C.AUDIO_CONTENT_TYPE_MUSIC)
            .setUsage(C.USAGE_MEDIA)
            .build()
    }

    single {
        ExoPlayer.Builder(get()).build().apply {
            setAudioAttributes(get(), true)
            setHandleAudioBecomingNoisy(true)
        }
    }

    single {
        DefaultDataSource.Factory(get())
    }
}