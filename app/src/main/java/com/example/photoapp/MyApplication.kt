package com.example.photoapp

import android.app.Application
import com.example.data.database.PhotosDatabase
import com.example.data.database.getDatabase
import com.example.photoapp.di.AppContainer

class MyApplication : Application() {
    lateinit var database: PhotosDatabase
    lateinit var appContainer: AppContainer

    override fun onCreate() {
        super.onCreate()
        database = getDatabase(applicationContext)
        appContainer = AppContainer(database)

    }
}