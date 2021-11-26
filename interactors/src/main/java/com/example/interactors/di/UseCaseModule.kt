package com.example.interactors.di

import com.example.interactors.FetchPhotosUseCase
import com.example.interactors.GetPhotosUseCase
import org.koin.dsl.module

val useCaseModule = module {
    factory { FetchPhotosUseCase(get()) }
    factory { GetPhotosUseCase(get()) }
}
