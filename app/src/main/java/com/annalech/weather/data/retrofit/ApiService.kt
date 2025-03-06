package com.annalech.weather.data.retrofit

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Headers

interface ApiService {

    @GET("weather?city=London")
    @Headers("X-Api-Key:ZapBLqLu0CfFvX9JOCiOdg==dLX5OCOkU0w0qui4")
    suspend fun getWeather(): Call<Weather>


}