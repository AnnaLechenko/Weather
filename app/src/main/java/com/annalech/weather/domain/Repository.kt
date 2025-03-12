package com.annalech.weather.domain

import com.annalech.weather.data.retrofit.entity.ResponseWeather
import retrofit2.Response

interface Repository {

    suspend fun getWeatherResponse(city:String ): Response<ResponseWeather>


}