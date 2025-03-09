package com.annalech.weather.data.retrofit

import com.annalech.weather.data.retrofit.entity.ResponseWeather
import com.jakewharton.retrofit2.converter.kotlinx.serialization.asConverterFactory
import kotlinx.serialization.json.Json
import okhttp3.MediaType.Companion.toMediaType
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


object ApiFactory {
    //    const val BASE_URL = "https://goweather.herokuapp.com/"
    private const val BASE_URL = "https://api.weatherapi.com/"
    const val API = "9a2b4948241d480b9d8203545250603 "

    val logging = HttpLoggingInterceptor().apply {
        setLevel(HttpLoggingInterceptor.Level.BODY)
    }
    val okHttp = OkHttpClient.Builder().addInterceptor(logging).build()

    // Create a custom Json instance with ignoreUnknownKeys = true
    val json = Json {
        ignoreUnknownKeys = true  // This tells the serializer to ignore extra keys
    }
    val contentType = "application/json".toMediaType()

    val apiService = Retrofit.Builder()
        .baseUrl(BASE_URL)
        .client(okHttp)
        .addConverterFactory(Json.asConverterFactory(contentType))
        .build()
        .create(ApiService::class.java)

}