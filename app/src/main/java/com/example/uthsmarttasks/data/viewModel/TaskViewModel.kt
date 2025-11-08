package com.example.uthsmarttasks.data.viewModel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.uthsmarttasks.data.model.Task
import com.example.uthsmarttasks.data.service.TaskApiClient
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class TaskViewModel : ViewModel() {

    private val _tasks = MutableStateFlow<List<Task>>(emptyList())
    val tasks = _tasks.asStateFlow()

    private val _isLoading = MutableStateFlow(true)
    val isLoading = _isLoading.asStateFlow()

    private val _error = MutableStateFlow<String?>(null)
    val error = _error.asStateFlow()

    init {
        fetchTasks()
    }

    private fun fetchTasks() {
        viewModelScope.launch {
            try {
                _isLoading.value = true

                // 🟢 Gọi từ TaskApiClient (không dùng ApiClient của product nữa)
                val response = TaskApiClient.apiService.getTasks()

                if (response.isSuccess) {
                    _tasks.value = response.data
                } else {
                    _error.value = response.message
                }

            } catch (e: Exception) {
                _error.value = e.localizedMessage ?: "Đã xảy ra lỗi không xác định"
            } finally {
                _isLoading.value = false
            }
        }
    }
}