package com.example.data.repository

import android.util.Log
import androidx.lifecycle.LiveData
import com.example.data.database.PhotosDatabase
import com.example.data.network.PhotosApi
import com.example.domain.Photo
import com.example.domain.Repository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import java.lang.Exception

class RepositoryImpl(private val database: PhotosDatabase) : Repository {
    override suspend fun fetchPhotos() {
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

    override fun getPhotos(): LiveData<List<Photo>> {
        return database.photosDao().getPhotos()
    }
}
