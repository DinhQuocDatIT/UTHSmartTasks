package com.example.uthsmarttasks.data.service

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object TaskApiClient {
    private const val BASE_URL = "https://amock.io/api/"

    val apiService: TaskApiService by lazy {
        Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(TaskApiService::class.java)
    }
}