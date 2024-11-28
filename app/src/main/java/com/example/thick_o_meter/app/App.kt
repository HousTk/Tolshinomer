package com.example.thick_o_meter.app

import android.app.Application
import com.example.thick_o_meter.DI.appModule
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin
import org.koin.core.logger.Level

class App(): Application() {
    override fun onCreate() {
        super.onCreate()

        startKoin{
            androidLogger(Level.ERROR)
            androidContext(androidContext = this@App)
            modules(listOf(appModule))
        }
    }
}