package com.example.photoapp.di

import com.example.photoapp.detail.DetailViewModel
import com.example.photoapp.overview.OverviewViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val viewModelModule = module {
    viewModel { OverviewViewModel(get(), get()) }
    viewModel { DetailViewModel(get(), get()) }
}