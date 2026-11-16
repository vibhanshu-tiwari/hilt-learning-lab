package com.vibh.hiltlearninglab.ui.home

import com.vibh.hiltlearninglab.data.model.Product

data class HomeUiState(
    val products: List<Product> = emptyList(),
    val isLoading: Boolean = false,
    val error: String? = null
)