package com.example.data.di

import com.example.data.network.ApiService
import org.koin.dsl.module
import retrofit2.Converter
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

private const val BASE_URL = "https://jsonplaceholder.typicode.com/"

val networkModule = module {
    single { GsonConverterFactory.create() as Converter.Factory}
    single<Retrofit> {
        Retrofit
            .Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(get())
            .build()
    }
    single { get<Retrofit>().create(ApiService::class.java) }
}