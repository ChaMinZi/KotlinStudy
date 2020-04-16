package com.example.kotlinstudy.network

import com.google.gson.annotations.SerializedName

data class CityX(
    @SerializedName("city")
    val city: String,
    @SerializedName("no")
    val no: Int,
    @SerializedName("url")
    val url: String
)