package com.bootcamp.tugas3_bootcampidn.api

import com.bootcamp.tugas3_bootcampidn.model.ResponseNews
import retrofit2.Call
import retrofit2.Callback
import retrofit2.http.GET
import retrofit2.http.Query

interface NewsApi {
    @GET("top-headlines")
    fun getTopHeadlines(
        @Query("country") country: String,
        @Query("apiKey") apiKey: String
    ): Call<ResponseNews>
}
