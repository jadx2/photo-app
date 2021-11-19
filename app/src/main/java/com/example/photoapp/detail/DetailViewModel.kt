package com.example.photoapp.detail

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.viewModelScope
import com.example.data.database.getDatabase
import com.example.photoapp.repository.PhotosRepository
import kotlinx.coroutines.launch

class DetailViewModel(application: Application) :
    AndroidViewModel(application) {

    private val database = getDatabase(application)
    private val photosRepository = PhotosRepository(database)

    init {
        fetchPhotos()
    }

    /***
     * Fetches the photos from database
     */
    fun fetchPhotos() {
        viewModelScope.launch {
            photosRepository.fetchPhotos()
        }
    }

    val photos = photosRepository.photos
}