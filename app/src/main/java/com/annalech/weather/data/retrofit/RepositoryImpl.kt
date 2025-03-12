package com.annalech.weather.data.retrofit

import android.app.Application
import com.annalech.weather.data.retrofit.entity.ResponseWeather
import com.annalech.weather.domain.Repository
import retrofit2.Response

class RepositoryImpl(application: Application):Repository {

    override suspend fun getWeatherResponse(city:String): Response<ResponseWeather> {
       return ApiFactory.apiService.getWeather(cityName = city)
    }


}