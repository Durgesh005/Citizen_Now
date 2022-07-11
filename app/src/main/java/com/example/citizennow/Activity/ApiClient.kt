package com.example.citizennow.Activity

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class ApiClient {

    companion object {
        var BASE_URL = "https://newsapi.org/v2/"

        fun Retrofit(): Retrofit {
            var retrofit = Retrofit.Builder().baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build()

            return retrofit
        }
    }

}

//https://newsapi.org/v2/top-headlines?sources=google-news-in&apiKey=b37c8ce464114d9484d7b172d94bd8f3