package com.example.interactors

import com.example.domain.Repository
import javax.inject.Inject

class FetchPhotosUseCase @Inject constructor(
private val repository: Repository)
{
    suspend operator fun invoke() {
        repository.fetchPhotos()
    }
}