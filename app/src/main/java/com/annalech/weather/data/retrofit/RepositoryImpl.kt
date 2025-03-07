package com.annalech.weather.data.retrofit

import com.annalech.weather.data.retrofit.entity.Weather
import com.annalech.weather.domain.Repository

class RepositoryImpl:Repository {
    override fun getWeather( ): Weather {
        TODO()
    }

    override fun loadCity(): String {
        TODO("Not yet implemented")
    }
}