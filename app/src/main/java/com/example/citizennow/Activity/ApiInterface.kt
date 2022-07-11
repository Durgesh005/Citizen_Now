package com.example.citizennow.Activity

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiInterface {
    @GET("top-headlines")
    fun getNews(
        @Query("country") c1: String,
        @Query("category") cate: String,
        @Query("apikey") key: String
    ): Call<News>
}


//https://newsapi.org/v2/top-headlines?sources=google-news-in&apiKey=b37c8ce464114d9484d7b172d94bd8f3