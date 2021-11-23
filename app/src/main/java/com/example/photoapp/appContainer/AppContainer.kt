package com.example.photoapp.appContainer

import com.example.data.database.PhotosDatabase
import com.example.data.repository.RepositoryImpl
import com.example.interactors.FetchPhotosUseCase
import com.example.interactors.GetPhotosUseCase

class AppContainer(database: PhotosDatabase) {
    private val repository = RepositoryImpl(database)
    val fetchPhotosUseCase = FetchPhotosUseCase(repository)
    val getPhotosUseCase = GetPhotosUseCase(repository)

    var overviewContainer: OverviewContainer? = null
    var detailViewContainer: DetailViewContainer? = null
}