package com.example.photoapp.di

import com.example.interactors.FetchPhotosUseCase
import com.example.interactors.GetPhotosUseCase
import com.example.photoapp.overview.OverviewViewModelFactory

class OverviewContainer(fetchPhotosUseCase: FetchPhotosUseCase, getPhotosUseCase: GetPhotosUseCase) {
    val overviewViewModelFactory = OverviewViewModelFactory(fetchPhotosUseCase, getPhotosUseCase)
}