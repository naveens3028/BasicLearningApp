package com.example.basiclearningapp

import okhttp3.ResponseBody
import retrofit2.Call
import retrofit2.http.GET

interface ApiInterface {

    @GET("api/users/2")
    fun getExampleData(): Call<ResponseBody>
}