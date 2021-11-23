package com.example.photoapp.appContainer

import com.example.data.repository.PhotosRepository
import com.example.photoapp.detail.DetailViewModelFactory

class DetailViewContainer(photosRepository: PhotosRepository) {
    val detailViewModelFactory = DetailViewModelFactory(photosRepository)
}