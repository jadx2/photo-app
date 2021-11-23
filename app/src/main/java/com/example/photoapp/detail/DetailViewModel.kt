package com.example.photoapp.detail

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.data.database.getDatabase
import com.example.data.network.PhotosApi
import com.example.data.repository.PhotosRepository
import kotlinx.coroutines.launch

class DetailViewModel(private val photosRepository: PhotosRepository) : ViewModel() {

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