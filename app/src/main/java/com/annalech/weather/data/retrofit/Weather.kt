package com.annalech.weather.data.retrofit

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable


@Serializable
data class Weather(

    @SerialName("wind_speed"   ) var windSpeed   : Double,
    @SerialName("temp"         ) var temp        : Int,


    @SerialName("sunrise"      ) var sunrise     : Int,
    @SerialName("sunset"       ) var sunset      : Int,

    @SerialName("min_temp"     ) var minTemp     : Int,
    @SerialName("max_temp"     ) var maxTemp     : Int

)