package com.vibh.hiltlearninglab.data.source

import com.vibh.hiltlearninglab.data.model.Product

interface ProductDataSource {
    fun getProducts(): List<Product>
}