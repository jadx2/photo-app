package com.example.photoapp.detail

import com.example.interactors.FetchPhotosUseCase
import com.example.interactors.GetPhotosUseCase
import com.example.photoapp.Factory

class DetailViewModelFactory(
    private val fetchPhotosUseCase: FetchPhotosUseCase,
    private val getPhotosUseCase: GetPhotosUseCase
) : Factory<DetailViewModel> {
    override fun create(): DetailViewModel {
            return DetailViewModel(fetchPhotosUseCase, getPhotosUseCase)
    }
}
