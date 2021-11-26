package com.example.data.di

import androidx.room.Room
import com.example.data.database.PhotosDatabase
import org.koin.android.ext.koin.androidContext
import org.koin.dsl.module

val databaseModule = module {
    single {
        Room.databaseBuilder(
            androidContext().applicationContext,
            PhotosDatabase::class.java,
            "photos"
        ).build()
    }
    factory { get<PhotosDatabase>().photosDao() }
}