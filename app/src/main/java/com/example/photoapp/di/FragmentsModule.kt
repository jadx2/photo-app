package com.example.photoapp.di

import com.example.photoapp.detail.DetailFragment
import com.example.photoapp.overview.OverviewFragment
import org.koin.androidx.fragment.dsl.fragment
import org.koin.dsl.module

val fragmentsModule = module {
    fragment { OverviewFragment() }
    fragment { DetailFragment() }
}
