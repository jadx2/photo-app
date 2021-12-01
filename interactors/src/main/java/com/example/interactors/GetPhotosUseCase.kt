package com.example.interactors

import com.example.domain.Photo
import com.example.domain.Repository
import javax.inject.Inject

class GetPhotosUseCase @Inject constructor(private val repository: Repository) {
    suspend operator fun invoke(): MutableList<Photo> = repository.getPhotos()
}