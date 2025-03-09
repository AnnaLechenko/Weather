package com.annalech.weather.presentation.secondPage

import android.app.Application
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider

class ViewModelFactory(
        val application: Application,
        val city:String)
    : ViewModelProvider.AndroidViewModelFactory(application) {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return ViewModelWeather(application,city) as T
    }
}