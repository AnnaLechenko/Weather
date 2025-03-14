package com.annalech.weather.data.retrofit.entity

import android.os.Parcelable
import kotlinx.parcelize.Parcelize
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import kotlinx.serialization.json.JsonIgnoreUnknownKeys
@Parcelize
@Serializable
@JsonIgnoreUnknownKeys
data class Location(
    @SerialName("name")val name: String,
    @SerialName("region")   val region: String,
    @SerialName("country")  val country: String
):Parcelable
