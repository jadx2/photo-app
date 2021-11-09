package com.example.photoapp.overview

import android.app.Application
import android.util.Log
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.example.photoapp.network.PhotosApi
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import java.lang.Exception

class OverviewViewModel(application: Application) : AndroidViewModel(application) {

    private val _photos = MutableLiveData<String>()
    val photos: LiveData<String>
        get() = _photos

    init {
        getPhotos()
    }

    private fun getPhotos() {
        viewModelScope.launch {
            withContext(Dispatchers.IO) {
                try {
                    val result = PhotosApi.retrofitService.getPhotos()
                    _photos.postValue("Success: ${result.size} photos retrieved")
                } catch (e: Exception) {
                    _photos.postValue("Failure: ${e.message}")
                }
            }
        }

    }

}