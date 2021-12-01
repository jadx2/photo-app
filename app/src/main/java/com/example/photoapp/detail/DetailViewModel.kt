package com.example.photoapp.detail

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.domain.Photo
import com.example.interactors.FetchPhotosUseCase
import com.example.interactors.GetPhotosUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class DetailViewModel @Inject constructor(
    private val fetchPhotosUseCase: FetchPhotosUseCase,
    private val getPhotosUseCase: GetPhotosUseCase
) :
    ViewModel() {

    private val _photos = MutableLiveData<MutableList<Photo>>()
    val photos: LiveData<MutableList<Photo>>
        get() = _photos

    init {
        fetchPhotos()
    }

    /***
     * Fetches the photos from database
     */
    fun fetchPhotos() {
        viewModelScope.launch {
            fetchPhotosUseCase.invoke()
            _photos.postValue(getPhotosUseCase.invoke())
        }
    }
}