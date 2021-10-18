package com.example.newsapp

import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Query

//https://newsapi.org/v2/top-headlines?country=us&category=business&apiKey=7d344e6b15104d86b1e431abcf948aa9
//https://newsapi.org/v2/everything?q=apple&from=2021-09-03&to=2021-09-03&sortBy=popularity&apiKey=7d344e6b15104d86b1e431abcf948aa9

const val BASE_URL = "https://newsapi.org/"
const val API_KEY = "7d344e6b15104d86b1e431abcf948aa9"

interface NewsInterface {

    @GET("v2/top-headlines?apiKey=$API_KEY")
    fun getHeadlines(@Query("country") country: String, @Query("page") page: Int) : Call<News>

}

object NewsService{
    val newsInstance: NewsInterface
    init {
        val retrofit = Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
        newsInstance = retrofit.create(NewsInterface::class.java)
    }
}