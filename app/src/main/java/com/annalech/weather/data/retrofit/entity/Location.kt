package com.annalech.weather.data.retrofit.entity

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import kotlinx.serialization.json.JsonIgnoreUnknownKeys

@Serializable
@JsonIgnoreUnknownKeys
data class Location(
    @SerialName("name")val name: String,
    @SerialName("region")   val region: String,
    @SerialName("country")  val country: String
)
