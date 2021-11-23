package com.example.photoapp.overview

import androidx.lifecycle.*
import com.example.interactors.FetchPhotosUseCase
import com.example.interactors.GetPhotosUseCase
import kotlinx.coroutines.launch

class OverviewViewModel(
    private val fetchPhotosUseCase: FetchPhotosUseCase,
    getPhotosUseCase: GetPhotosUseCase
) : ViewModel() {

    private val _navigateToSelectedPhoto = MutableLiveData<Int?>()
    val navigateToSelectedPhoto: LiveData<Int?>
        get() = _navigateToSelectedPhoto

    init {
        fetchPhotos()
    }

    fun fetchPhotos() {
        viewModelScope.launch {
            fetchPhotosUseCase.invoke()
        }
    }

    /***
     * Fetches the photos from repository
     */

    val photos = getPhotosUseCase.invoke()

    fun displayPhotoDetails(photoPosition: Int) {
        _navigateToSelectedPhoto.value = photoPosition
    }

    fun displayPhotoDetailsComplete() {
        _navigateToSelectedPhoto.value = null
    }
}