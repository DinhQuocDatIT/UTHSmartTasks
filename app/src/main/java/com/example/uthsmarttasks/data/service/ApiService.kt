package com.example.uthsmarttasks.data.service

import com.example.uthsmarttasks.data.model.Product
import com.example.uthsmarttasks.data.model.TaskResponse
import com.example.uthsmarttasks.data.repository.ProductResponse
import retrofit2.http.GET



interface ApiService {
    @GET("v2/product")
    suspend fun getProduct(): Product
    @GET("researchUTH/tasks")
    suspend fun getTasks(): TaskResponse
}