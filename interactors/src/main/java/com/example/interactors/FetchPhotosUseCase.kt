package com.example.interactors

import com.example.domain.Repository

class FetchPhotosUseCase(private val repository: Repository) {
    suspend operator fun invoke() = repository.fetchPhotos()
}