package com.vibh.hiltlearninglab.ui.home

import androidx.lifecycle.ViewModel
import com.vibh.hiltlearninglab.data.model.Product
import com.vibh.hiltlearninglab.data.repository.ProductRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    productRepository: ProductRepository
): ViewModel(){

    private val _uiState = MutableStateFlow(
        HomeUiState(
            products = productRepository.getProducts()
        )
    )

    val uiState: StateFlow<HomeUiState> = _uiState.asStateFlow()

}