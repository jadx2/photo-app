package com.example.photoapp.overview

import android.util.Log
import androidx.lifecycle.*
import com.example.data.repository.PhotosRepository
import kotlinx.coroutines.launch

class OverviewViewModel(private val photosRepository: PhotosRepository) : ViewModel() {

    private val _navigateToSelectedPhoto = MutableLiveData<Int?>()
    val navigateToSelectedPhoto: LiveData<Int?>
        get() = _navigateToSelectedPhoto

    init {
        fetchPhotos()
    }

    fun fetchPhotos() {
        viewModelScope.launch {
            photosRepository.fetchPhotos()
        }
    }

    /***
     * Fetches the photos from repository
     */

    val photos = photosRepository.photos

    fun displayPhotoDetails(photoPosition: Int) {
        _navigateToSelectedPhoto.value = photoPosition
    }

    fun displayPhotoDetailsComplete() {
        _navigateToSelectedPhoto.value = null
    }
}