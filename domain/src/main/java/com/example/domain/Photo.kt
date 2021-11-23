package com.example.domain

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "photos_table")
data class Photo(
    @PrimaryKey
    @ColumnInfo(name = "id")
    val id: Int,
    @ColumnInfo(name = "albumId")
    val albumId: Int,
    @ColumnInfo(name = "title")
    val title: String?,
    @ColumnInfo(name = "url")
    val url: String?,
    @ColumnInfo(name = "thumbnailUrl")
    val thumbnailUrl: String?
)


