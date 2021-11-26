package com.example.photoapp

import android.app.Application
import com.example.data.di.databaseModule
import com.example.data.di.networkModule
import com.example.data.di.repositoryModule
import com.example.interactors.di.useCaseModule
import com.example.photoapp.di.*
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.androidx.fragment.koin.fragmentFactory
import org.koin.core.context.startKoin
import org.koin.core.logger.Level

class MyApplication : Application() {
    override fun onCreate() {
        super.onCreate()
        startKoin {
            fragmentFactory()
            androidLogger(Level.ERROR)
            androidContext(this@MyApplication)
            modules(appModules + dataModules + interactorsModule)
        }
    }

    private val appModules = listOf(fragmentsModule, viewModelModule)
    private val dataModules = listOf(databaseModule, networkModule, repositoryModule)
    private val interactorsModule = listOf(useCaseModule)
}