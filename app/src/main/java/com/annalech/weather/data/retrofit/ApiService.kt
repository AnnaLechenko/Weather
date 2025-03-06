package com.annalech.weather.data.retrofit

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Headers

interface ApiService {

    @GET("/current.json?key=9a2b4948241d480b9d8203545250603&q=Moscow")
   // @Headers("X-Api-Key:9a2b4948241d480b9d8203545250603")
    suspend fun getWeather(): Call<Weather>


}