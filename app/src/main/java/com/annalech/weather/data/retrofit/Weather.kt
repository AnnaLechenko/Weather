package com.annalech.weather.data.retrofit

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable


@Serializable
data class Weather(
    @SerialName("name") var name:String,

    @SerialName("wind_kph"   ) var windSpeed   : Double,
    @SerialName("temp_c"         ) var temp        : Int,


    @SerialName("last_updated"      ) var last_updated     : Int,
    @SerialName("humidity"       ) var humidity   : Int,



)