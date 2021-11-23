package com.example.photoapp.detail

import com.example.data.repository.PhotosRepository
import com.example.photoapp.Factory

class DetailViewModelFactory(
    private val repository: PhotosRepository
) : Factory<DetailViewModel> {
    override fun create(): DetailViewModel {
            return DetailViewModel(repository)
    }
}
