package com.annalech.weather.data.retrofit

import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


object ApiFactory {
    //    const val BASE_URL = "https://goweather.herokuapp.com/"
    private const val BASE_URL = "https://api.weatherapi.com/"
    private const val API = "ZapBLqLu0CfFvX9JOCiOdg==dLX5OCOkU0w0qui4"

    val logging = HttpLoggingInterceptor().apply {
        setLevel(HttpLoggingInterceptor.Level.BODY)
    }

    val okHttp = OkHttpClient.Builder().addInterceptor(logging).build()

    val apiService = Retrofit.Builder()
        .baseUrl(BASE_URL)
        .client(okHttp)
        .addConverterFactory(GsonConverterFactory.create())
        .build()
        .create(ApiService::class.java)

}