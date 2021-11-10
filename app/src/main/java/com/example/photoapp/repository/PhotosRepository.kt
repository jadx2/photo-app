package com.example.photoapp.repository

import android.util.Log
import androidx.lifecycle.LiveData
import com.example.photoapp.database.Photo
import com.example.photoapp.database.PhotosDatabase
import com.example.photoapp.network.PhotosApi
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import java.lang.Exception

class PhotosRepository(private val database: PhotosDatabase) {
    val photos = database.photosDao.getPhotos()

    suspend fun fetchPhotos() {
        withContext(Dispatchers.IO) {
            try {
                val photos = PhotosApi.retrofitService.getPhotos().take(25)
                photos.forEach {
                    val photo = Photo(it.id, it.albumId, it.title, it.url, it.thumbnailUrl)
                    database.photosDao.insert(photo)
                }
            } catch (e: Exception) {
            }
        }
    }

}