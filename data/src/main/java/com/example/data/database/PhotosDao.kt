package com.example.data.database

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy.REPLACE
import androidx.room.Query

@Dao
interface PhotosDao {
    @Insert(onConflict = REPLACE)
    fun insert(photoEntity: PhotoEntity)

    @Query("SELECT * from photos_table")
    fun getPhotos(): List<PhotoEntity>
}