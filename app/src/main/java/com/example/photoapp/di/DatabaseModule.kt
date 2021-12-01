package com.example.photoapp.di

import android.content.Context
import androidx.room.Room
import com.example.data.database.PhotosDao
import com.example.data.database.PhotosDatabase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class DatabaseModule {
    @Singleton
    @Provides
    fun providesDatabaseInstance(@ApplicationContext context: Context): PhotosDatabase {
        return Room.databaseBuilder(
            context.applicationContext,
            PhotosDatabase::class.java,
            "photos"
        ).build()
    }

    @Singleton
    @Provides
    fun providesDao(database: PhotosDatabase ): PhotosDao {
        return database.photosDao()
    }

}