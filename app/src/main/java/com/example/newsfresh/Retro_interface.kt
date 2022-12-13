package com.example.newsfresh

import retrofit2.Call
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Query

const val base_url = "https://newsapi.org/"
const val API_KEY = "10f78619e97448c0899d07ec437a5d38"

//https://newsapi.org/v2/top-headlines?country=in&category=business&apiKey=10f78619e97448c0899d07ec437a5d38
interface QuotesApi {

    @GET("v2/top-headlines?apikey=$API_KEY")

    fun getHeadLines(@Query("country")country : String,@Query("page") page : Int): Call<datalist>
}

object Retro_interface{

    val newsInstance : QuotesApi
    init{

        val retrofit = Retrofit.Builder().baseUrl(base_url)
            .addConverterFactory(GsonConverterFactory.create()).build()

        newsInstance=retrofit.create(QuotesApi::class.java)
    }
}