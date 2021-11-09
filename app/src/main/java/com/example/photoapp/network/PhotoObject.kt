package com.example.photoapp.network

import com.google.gson.annotations.SerializedName

data class PhotoObject(
    @SerializedName("id")
    val id: Float,
    @SerializedName("albumId")
    val albumId: Float,
    @SerializedName("title")
    val title: String,
    @SerializedName("url")
    val url: String,
    @SerializedName("thumbnailUrl")
    val thumbnailUrl: String
)