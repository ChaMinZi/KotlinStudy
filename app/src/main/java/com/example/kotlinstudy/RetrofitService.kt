package com.example.kotlinstudy

import retrofit2.Call
import retrofit2.http.GET

interface RetrofitService {
    @GET("/api/cities")
    fun requestCity() : Call<City>
}