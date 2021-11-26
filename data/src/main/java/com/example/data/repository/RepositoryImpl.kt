package com.example.data.repository

import android.util.Log
import androidx.lifecycle.LiveData
import com.example.data.database.PhotosDao
import com.example.data.network.ApiService
import com.example.domain.Photo
import com.example.domain.Repository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import org.koin.core.component.KoinComponent
import java.lang.Exception

class RepositoryImpl(private val api: ApiService, private val photosDao: PhotosDao) : Repository,
    KoinComponent {
    override suspend fun fetchPhotos() {
        withContext(Dispatchers.IO) {
            try {
                val photos = api.getPhotos().take(25)
                photos.forEach {
                    val photo = Photo(it.id, it.albumId, it.title, it.url, it.thumbnailUrl)
                    photosDao.insert(photo)
                }
            } catch (e: Exception) {
                Log.wtf("Jaim", "Failure: ${e.message}")
            }
        }
    }

    override fun getPhotos(): LiveData<List<Photo>> {
        return photosDao.getPhotos()
    }
}
