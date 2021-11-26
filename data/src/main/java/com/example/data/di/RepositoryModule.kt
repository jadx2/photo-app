package com.example.data.di

import com.example.data.repository.RepositoryImpl
import com.example.domain.Repository
import org.koin.dsl.module


val repositoryModule= module {
    factory<Repository> { RepositoryImpl(get(), get()) }
}
