package com.example.photoapp.di

import com.example.interactors.FetchPhotosUseCase
import com.example.interactors.GetPhotosUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

//@Module
//@InstallIn(SingletonComponent::class)
//class UseCaseModule {
//    @Singleton
//    @Provides
//    fun providesFetchUseCase(fetchPhotosUseCase: FetchPhotosUseCase): FetchPhotosUseCase {
//        return fetchPhotosUseCase
//    }
//
//    @Singleton
//    @Provides
//    fun providesGetUseCase(getPhotosUseCase: GetPhotosUseCase): GetPhotosUseCase {
//        return getPhotosUseCase
//    }
//}