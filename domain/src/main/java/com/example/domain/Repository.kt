package com.example.domain

interface Repository {
    suspend fun fetchPhotos()
    suspend fun getPhotos() : MutableList<Photo>
}