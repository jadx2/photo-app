package com.example.interactors

import androidx.lifecycle.LiveData
import com.example.domain.Photo
import com.example.domain.Repository

class GetPhotosUseCase(private val repository: Repository) {
    operator fun invoke(): LiveData<List<Photo>> = repository.getPhotos()
}