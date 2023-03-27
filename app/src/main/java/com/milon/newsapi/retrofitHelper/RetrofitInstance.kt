package com.milon.newsapi.retrofitHelper

import com.milon.newsapi.apiInterface.ApiInterface
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitInstance {

    private val retrofit by lazy {

        Retrofit.Builder().baseUrl("https://newsapi.org/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    val apiInterface by lazy {
        retrofit.create(ApiInterface::class.java)
    }

}