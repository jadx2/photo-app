package com.example.photoapp.appContainer

import com.example.interactors.FetchPhotosUseCase
import com.example.interactors.GetPhotosUseCase
import com.example.photoapp.detail.DetailViewModelFactory

class DetailViewContainer(fetchPhotosUseCase: FetchPhotosUseCase,getPhotosUseCase: GetPhotosUseCase ) {
    val detailViewModelFactory = DetailViewModelFactory(fetchPhotosUseCase, getPhotosUseCase)
}