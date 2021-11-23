package com.example.photoapp

interface Factory<T> {
    fun create(): T
}