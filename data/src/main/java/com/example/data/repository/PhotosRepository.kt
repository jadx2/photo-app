package com.example.data.repository

import android.util.Log
import com.example.data.database.Photo
import com.example.data.database.PhotosDatabase
import com.example.data.network.PhotosApi
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import java.lang.Exception

class PhotosRepository(private val database: PhotosDatabase) {
    val photos = database.photosDao().getPhotos()

    suspend fun fetchPhotos() {
        withContext(Dispatchers.IO) {
            try {
                val photos = PhotosApi.retrofitService.getPhotos().take(25)
                photos.forEach {
                    val photo = Photo(it.id, it.albumId, it.title, it.url, it.thumbnailUrl)
                    database.photosDao().insert(photo)
                }
            } catch (e: Exception) {
                Log.wtf("Jaim", "Failure: ${e.message}")
            }
        }
    }

}