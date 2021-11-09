package com.example.photoapp.repository

import com.example.photoapp.database.PhotosDatabase
import com.example.photoapp.network.PhotosApi
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class PhotosRepository(val database: PhotosDatabase) {
    suspend fun fetchPhotos() {
        withContext(Dispatchers.IO) {
            val photos = PhotosApi.retrofitService.getPhotos()
//            database.photosDao.insertAll(photos)
        }
    }

}