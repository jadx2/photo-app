package com.example.data.network

import retrofit2.http.GET

interface ApiService {
    @GET("photos")
    suspend fun getPhotos():
            List<PhotoObject>
}