package com.example.photoapp.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [Photo::class], version = 1, exportSchema = false)
abstract class PhotosDatabase : RoomDatabase() {
    abstract val photosDao: PhotosDao
}

private lateinit var INSTANCE: PhotosDatabase

fun getDatabase(context: Context): PhotosDatabase {
    synchronized(PhotosDatabase::class.java) {
        if (!::INSTANCE.isInitialized) {
            INSTANCE = Room.databaseBuilder(
                context.applicationContext,
                PhotosDatabase::class.java,
                "photos"
            ).build()
        }
    }
    return INSTANCE
}