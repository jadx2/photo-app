package com.example.photoapp.detail

import android.app.Application
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.photoapp.database.Photo

class DetailViewModelFactory(
    private val photo: Photo,
    private val application: Application
) : ViewModelProvider.Factory {
    @Suppress("uncheck_cast")
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(DetailViewModel::class.java)) {
            return DetailViewModel(photo, application) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}
