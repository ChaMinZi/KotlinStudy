package com.example.kotlinstudy.network

import com.example.kotlinstudy.network.City
import retrofit2.Call
import retrofit2.http.GET

interface RetrofitService {
    @GET("/api/cities")
    fun requestCity() : Call<City>
}