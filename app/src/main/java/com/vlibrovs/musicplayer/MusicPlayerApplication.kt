package com.vlibrovs.musicplayer

import android.app.Application
import com.vlibrovs.musicplayer.di.appModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class MusicPlayerApplication : Application() {

    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidContext(this@MusicPlayerApplication)
            modules(appModule)
        }
    }

}