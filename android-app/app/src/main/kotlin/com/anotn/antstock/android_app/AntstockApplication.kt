package com.anotn.antstock.android_app

import android.app.Application
import dagger.hilt.android.HiltAndroidApp

@HiltAndroidApp
class AntstockApplication : Application() {
    override fun onCreate() {
        super.onCreate()
    }
}