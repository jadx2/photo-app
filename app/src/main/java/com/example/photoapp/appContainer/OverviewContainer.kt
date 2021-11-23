package com.example.photoapp.appContainer

import com.example.data.repository.PhotosRepository
import com.example.photoapp.overview.OverviewViewModelFactory

class OverviewContainer(photosRepository: PhotosRepository) {
    val overviewViewModelFactory = OverviewViewModelFactory(photosRepository)
}