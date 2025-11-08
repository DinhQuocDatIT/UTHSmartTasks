package com.example.uthsmarttasks.data.viewModel



import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.uthsmarttasks.data.model.Task
import com.example.uthsmarttasks.data.service.TaskApiClient
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class TaskDetailViewModel : ViewModel() {

    private val _task = MutableStateFlow<Task?>(null)
    val task = _task.asStateFlow()

    private val _isLoading = MutableStateFlow(true)
    val isLoading = _isLoading.asStateFlow()

    private val _error = MutableStateFlow<String?>(null)
    val error = _error.asStateFlow()
    private val _deleteSuccess = MutableStateFlow(false)
    val deleteSuccess = _deleteSuccess.asStateFlow()
    fun fetchTaskDetail(id: Int) {
        viewModelScope.launch {
            try {
                _isLoading.value = true
                val response = TaskApiClient.apiService.getTaskDetail(id)

                if (response.isSuccess) {
                    _task.value = response.data
                } else {
                    _error.value = response.message
                }

            } catch (e: Exception) {
                _error.value = e.localizedMessage ?: "Lỗi không xác định"
            } finally {
                _isLoading.value = false
            }
        }
    }
    fun deleteTask(id: Int) {
        viewModelScope.launch {
            try {
                _isLoading.value = true
                val response = TaskApiClient.apiService.deleteTask(id)
                if (response.isSuccess) {
                    _deleteSuccess.value = true
                } else {
                    _error.value = response.message
                }
            } catch (e: Exception) {
                _error.value = e.message
            } finally {
                _isLoading.value = false
            }
        }
    }
}
