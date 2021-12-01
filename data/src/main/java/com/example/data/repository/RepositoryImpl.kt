package com.example.data.repository

import android.util.Log
import com.example.data.database.PhotosDao
import com.example.data.network.ApiService
import com.example.domain.Photo
import com.example.domain.Repository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import java.lang.Exception
import javax.inject.Inject

class RepositoryImpl @Inject constructor(
    private val api: ApiService,
    private val photosDao: PhotosDao
) : Repository {

    override suspend fun fetchPhotos() {
        withContext(Dispatchers.IO) {
            try {
                val photos = api.getPhotos().take(25)
                photos.forEach {
                    photosDao.insert(it.mapToRoomEntity())
                }
            } catch (e: Exception) {
                Log.wtf("Jaim", "Failure: ${e.message}")
            }
        }
    }

    override suspend fun getPhotos(): MutableList<Photo> {
        val photos = mutableListOf<Photo>()
        withContext(Dispatchers.IO) {
            try {
                photosDao.getPhotos().forEach {
                    photos.add(it.mapToDomainModel())
                }
            } catch (e: Exception) {
                Log.wtf("Jaim", "Failure: ${e.message}")
            }
        }
        return photos
    }
}
