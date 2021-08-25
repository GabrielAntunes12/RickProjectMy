package com.example.rickprojectmy.app

import android.app.Application
import com.eykel.rickywithdi.apiModule
import com.eykel.rickywithdi.netModule
import com.eykel.rickywithdi.repositoryModule
import com.eykel.rickywithdi.viewModelModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class MainApplication : Application() {

    override fun onCreate() {
        super.onCreate()

        startKoin {
            androidContext(this@MainApplication)
            modules(listOf(apiModule, netModule, viewModelModule, repositoryModule))
        }
    }
}