package com.example.uthsmarttasks.data.viewModel



import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.uthsmarttasks.data.model.Product
import com.example.uthsmarttasks.data.service.RetrofitClient

import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class ProductViewModel : ViewModel() {
    private val _product = MutableStateFlow<Product?>(null)
    val product: StateFlow<Product?> = _product

    init {
        fetchProduct()
    }

    private fun fetchProduct() {
        viewModelScope.launch {
            try {
                val response = RetrofitClient.api.getProduct()
                _product.value = response
                println("✅ API loaded product: ${response.name}")
            } catch (e: Exception) {
                println("❌ API error: ${e.localizedMessage}")
                e.printStackTrace()
                _product.value = null
            }
        }
    }
}