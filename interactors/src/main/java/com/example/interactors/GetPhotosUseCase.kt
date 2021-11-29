package com.example.interactors

import com.example.domain.Photo
import com.example.domain.Repository

class GetPhotosUseCase(private val repository: Repository) {
    suspend operator fun invoke(): MutableList<Photo> = repository.getPhotos()
}