package com.annalech.weather.domain

import com.annalech.weather.data.retrofit.entity.ResponseWeather
import retrofit2.Response

class GetWeatherResponse_UseCase(val repository: Repository) {
    operator suspend fun invoke(city: String): Response<ResponseWeather> {
       return repository.getWeatherResponse(city)
    }
}