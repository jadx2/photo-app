package com.example.data.database

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy.REPLACE
import androidx.room.Query
import com.example.domain.Photo

@Dao
interface PhotosDao {
    @Insert(onConflict = REPLACE)
    fun insert(photo: Photo)

    @Query("SELECT * from photos_table")
    fun getPhotos(): LiveData<List<Photo>>
}