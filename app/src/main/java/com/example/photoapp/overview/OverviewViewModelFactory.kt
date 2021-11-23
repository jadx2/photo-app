package com.example.photoapp.overview

import com.example.interactors.FetchPhotosUseCase
import com.example.interactors.GetPhotosUseCase
import com.example.photoapp.Factory

class OverviewViewModelFactory(
    private val fetchPhotosUseCase: FetchPhotosUseCase,
    private val getPhotosUseCase: GetPhotosUseCase
): Factory<OverviewViewModel> {
    override fun create(): OverviewViewModel {
        return OverviewViewModel(fetchPhotosUseCase, getPhotosUseCase)
    }
}