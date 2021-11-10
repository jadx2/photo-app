package com.example.photoapp.database

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy.REPLACE
import androidx.room.Query

@Dao
interface PhotosDao {
    @Insert(onConflict = REPLACE)
    fun insert(photos: Photo)

    @Query("SELECT * from photos_table")
    fun getPhotos(): LiveData<List<Photo>>
}