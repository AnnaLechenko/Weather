package com.annalech.weather.data.retrofit

import com.annalech.weather.data.retrofit.entity.ResponseWeather
import retrofit2.Call
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {
//?key=9a2b4948241d480b9d8203545250603&q=Moscow
    @GET("v1/current.json")
   // @Headers("X-Api-Key:9a2b4948241d480b9d8203545250603")
    suspend fun getWeather(
        @Query("key") apiKey:String,
        @Query("q") cityName:String
    ): Response<ResponseWeather>


}