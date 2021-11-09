package com.example.photoapp.overview

import android.app.Application
import android.util.Log
import androidx.lifecycle.AndroidViewModel

class OverviewViewModel(application: Application) : AndroidViewModel(application) {
    init {
        Log.wtf("Jaim", "OverviewViewModel created!")
    }
}