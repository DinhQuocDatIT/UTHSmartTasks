package com.example.uthsmarttasks.data.repository

import com.example.uthsmarttasks.data.model.Task

data class TaskDetailResponse(
    val isSuccess: Boolean,
    val message: String,
    val data: Task
)