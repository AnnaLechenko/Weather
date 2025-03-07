package com.annalech.weather.data.retrofit.entity

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class TemperatureCurrent(
    @SerialName(  "temp_c") val   temp_c:Int,
@SerialName( "wind_kph") val  wind_kph:Double,
    @SerialName("humidity") val humidity: Int

)
