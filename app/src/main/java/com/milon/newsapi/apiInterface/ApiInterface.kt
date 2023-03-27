package com.milon.newsapi.apiInterface

import com.milon.newsapi.model.Article
import com.milon.newsapi.model.countryList
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiInterface {


   @GET("v2/top-headlines")
   fun getData(@Query("apiKey") apiKey: String, @Query("country") country: String,@Query("page") page: Int) : Call<countryList>

}