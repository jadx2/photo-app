package com.example.photoapp.overview

import androidx.lifecycle.*
import com.example.domain.Photo
import com.example.interactors.FetchPhotosUseCase
import com.example.interactors.GetPhotosUseCase
import kotlinx.coroutines.launch

class OverviewViewModel(
    private val fetchPhotosUseCase: FetchPhotosUseCase,
    private val getPhotosUseCase: GetPhotosUseCase
) : ViewModel() {

    private val _photos = MutableLiveData<MutableList<Photo>>()
    val photos: LiveData<MutableList<Photo>>
        get() = _photos

    private val _navigateToSelectedPhoto = MutableLiveData<Int?>()
    val navigateToSelectedPhoto: LiveData<Int?>
        get() = _navigateToSelectedPhoto

    init {
        fetchPhotos()
    }

    fun fetchPhotos() {
        viewModelScope.launch {
            fetchPhotosUseCase.invoke()
            _photos.postValue(getPhotosUseCase.invoke())
        }
    }

    fun displayPhotoDetails(photoPosition: Int) {
        _navigateToSelectedPhoto.value = photoPosition
    }

    fun displayPhotoDetailsComplete() {
        _navigateToSelectedPhoto.value = null
    }
}