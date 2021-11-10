package com.example.photoapp.overview

import android.app.Application
import android.util.Log
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.example.photoapp.database.Photo
import com.example.photoapp.database.getDatabase
import com.example.photoapp.repository.PhotosRepository
import kotlinx.coroutines.launch

class OverviewViewModel(application: Application) : AndroidViewModel(application) {

    private val database = getDatabase(application)
    private val photosRepository = PhotosRepository(database)

    init {
        viewModelScope.launch {
            photosRepository.fetchPhotos()
        }
    }

    val photos = photosRepository.photos
}