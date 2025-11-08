package com.example.uthsmarttasks.data.service

import com.example.uthsmarttasks.data.model.ApiResponse
import com.example.uthsmarttasks.data.model.Task
import com.example.uthsmarttasks.data.model.TaskResponse
import com.example.uthsmarttasks.data.repository.TaskDetailResponse
import retrofit2.http.DELETE
import retrofit2.http.GET
import retrofit2.http.Path

interface TaskApiService {
    @GET("researchUTH/tasks")
    suspend fun getTasks(): TaskResponse
    @GET("researchUTH/task/{id}")
    suspend fun getTaskDetail(@Path("id") id: Int): TaskDetailResponse
    @DELETE("researchUTH/task/{id}")
    suspend fun deleteTask(@Path("id") id: Int): ApiResponse
}