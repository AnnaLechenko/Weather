package com.annalech.weather.domain

import com.annalech.weather.data.retrofit.ApiService
import com.annalech.weather.data.retrofit.Weather

interface Repository {

    fun getWeather( ):Weather

    fun loadCity():String
}