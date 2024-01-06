package com.yusy.surviveinjlu

import android.app.Application
import com.yusy.surviveinjlu.data.AppContainer
import com.yusy.surviveinjlu.data.AppDataContainer

class MainApplication: Application() {
    lateinit var container: AppContainer

    override fun onCreate() {
        super.onCreate()
        container = AppDataContainer(this)
    }
}