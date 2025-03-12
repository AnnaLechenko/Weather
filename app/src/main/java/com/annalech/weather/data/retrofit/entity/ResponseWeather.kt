package com.annalech.weather.data.retrofit.entity

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class ResponseWeather(
    @SerialName("location")val location : Location,
    @SerialName("current") val currentTemperature: TemperatureCurrent
)
