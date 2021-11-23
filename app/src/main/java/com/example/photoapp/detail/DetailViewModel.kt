package com.example.photoapp.detail

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.interactors.FetchPhotosUseCase
import com.example.interactors.GetPhotosUseCase
import kotlinx.coroutines.launch

class DetailViewModel(private val fetchPhotosUseCase: FetchPhotosUseCase, getPhotosUseCase: GetPhotosUseCase) :
    ViewModel() {

    init {
        fetchPhotos()
    }

    /***
     * Fetches the photos from database
     */
    fun fetchPhotos() {
        viewModelScope.launch {
            fetchPhotosUseCase.invoke()
        }
    }

    val photos = getPhotosUseCase.invoke()
}