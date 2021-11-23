package com.example.domain

import androidx.lifecycle.LiveData

interface Repository {
    suspend fun fetchPhotos()
    fun getPhotos() : LiveData<List<Photo>>
}