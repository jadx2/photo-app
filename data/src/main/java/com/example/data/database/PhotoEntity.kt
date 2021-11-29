package com.example.data.database

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.data.DomainMapper
import com.example.domain.Photo

@Entity(tableName = "photos_table")
data class PhotoEntity(
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
) : DomainMapper<Photo> {
    override fun mapToDomainModel() = Photo(id, title, url)
}


