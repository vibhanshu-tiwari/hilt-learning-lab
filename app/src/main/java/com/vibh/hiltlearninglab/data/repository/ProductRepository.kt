package com.vibh.hiltlearninglab.data.repository

import com.vibh.hiltlearninglab.data.model.Product

interface ProductRepository {
    fun getProducts(): List<Product>
}