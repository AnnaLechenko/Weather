package com.annalech.weather.data.retrofit

import com.annalech.weather.data.retrofit.entity.ResponseWeather
import retrofit2.Call
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {

    @GET("v1/current.json")
    suspend fun getWeather(
        @Query("key") apiKey:String =ApiFactory.API,
        @Query("q") cityName:String
    ): Response<ResponseWeather>


}