package com.annalech.weather.domain

import com.annalech.weather.data.retrofit.entity.Weather

interface Repository {

    fun getWeather( ): Weather

    fun loadCity():String
}