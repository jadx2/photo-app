package com.example.photoapp.detail

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.photoapp.database.Photo

class DetailViewModel(photo: Photo, application: Application) :
    AndroidViewModel(application) {
    private val _selectedPhoto = MutableLiveData<Photo>()
    val selectedPhoto: LiveData<Photo>
        get() = _selectedPhoto

    init {
        _selectedPhoto.value = photo
    }
}