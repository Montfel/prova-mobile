package com.example.provamobile

import android.app.Application
import dagger.hilt.android.HiltAndroidApp

@HiltAndroidApp
class SSBookApp : Application() {
    override fun onCreate() {
        super.onCreate()
    }
}
