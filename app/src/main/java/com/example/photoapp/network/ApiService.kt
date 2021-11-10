package com.example.photoapp.network

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET

private const val BASE_URL = "https://jsonplaceholder.typicode.com/"

private val retrofit = Retrofit
    .Builder()
    .baseUrl(BASE_URL)
    .addConverterFactory(GsonConverterFactory.create())
    .build()

interface ApiService {
    @GET("photos")
    suspend fun getPhotos():
            List<PhotoObject>
}

object PhotosApi {
    val retrofitService: ApiService by lazy {
        retrofit.create(ApiService::class.java)
    }
}