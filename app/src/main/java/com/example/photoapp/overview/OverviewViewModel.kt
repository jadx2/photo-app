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

    private val _navigateToSelectedPhoto = MutableLiveData<Photo?>()
    val navigateToSelectedPhoto: LiveData<Photo?>
        get() = _navigateToSelectedPhoto

    init {
        fetchPhotos()
    }

    fun fetchPhotos() {
        viewModelScope.launch {
            photosRepository.fetchPhotos()
        }
    }

    val photos = photosRepository.photos

    fun displayPhotoDetails(photo: Photo) {
        _navigateToSelectedPhoto.value = photo
    }

    fun displayPhotoDetailsComplete() {
        _navigateToSelectedPhoto.value = null
    }
}