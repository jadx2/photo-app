package com.example.data.network

import com.example.data.RoomMapper
import com.example.data.database.PhotoEntity
import com.google.gson.annotations.SerializedName

data class PhotoResponse(
    @SerializedName("id")
    val id: Int,
    @SerializedName("albumId")
    val albumId: Int,
    @SerializedName("title")
    val title: String,
    @SerializedName("url")
    val url: String,
    @SerializedName("thumbnailUrl")
    val thumbnailUrl: String
) : RoomMapper<PhotoEntity> {
    override fun mapToRoomEntity() = PhotoEntity(id, albumId, title, url, thumbnailUrl)
}