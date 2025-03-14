package com.annalech.weather.data.retrofit.entity

import android.os.Parcelable
import kotlinx.parcelize.Parcelize
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
@Parcelize
@Serializable
data class ResponseWeather(
    @SerialName("location")val location : Location,
    @SerialName("current") val currentTemperature: TemperatureCurrent
):Parcelable
