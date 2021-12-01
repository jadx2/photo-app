package com.example.photoapp.di

import com.example.data.repository.RepositoryImpl
import com.example.domain.Repository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class RepositoryModule {
    @Singleton
    @Provides
    fun providesRepository(repository: RepositoryImpl): Repository {
        return repository
    }
}
