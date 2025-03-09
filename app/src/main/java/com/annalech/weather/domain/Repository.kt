package com.annalech.weather.domain

import com.annalech.weather.data.retrofit.entity.ResponseWeather

interface Repository {

    fun getWeather( ): ResponseWeather

    fun loadCity():String
}