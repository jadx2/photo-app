package com.example.photoapp.overview

import com.example.data.repository.PhotosRepository
import com.example.photoapp.Factory

class OverviewViewModelFactory(
    private val repository: PhotosRepository
): Factory<OverviewViewModel> {
    override fun create(): OverviewViewModel {
        return OverviewViewModel(repository)
    }
}