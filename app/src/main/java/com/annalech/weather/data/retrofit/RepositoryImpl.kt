package com.annalech.weather.data.retrofit

import com.annalech.weather.data.retrofit.entity.ResponseWeather
import com.annalech.weather.domain.Repository

class RepositoryImpl:Repository {
    override fun getWeather( ): ResponseWeather {
        TODO()
    }

    override fun loadCity(): String {
        TODO("Not yet implemented")
    }
}