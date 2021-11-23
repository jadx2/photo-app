package com.example.photoapp.appContainer

import android.content.Context
import com.example.data.database.PhotosDatabase
import com.example.data.database.getDatabase
import com.example.data.network.PhotosApi
import com.example.data.repository.PhotosRepository

class AppContainer(database: PhotosDatabase) {
    val photosRepository = PhotosRepository(database)

    var overviewContainer: OverviewContainer? = null
    var detailViewContainer: DetailViewContainer? = null
}