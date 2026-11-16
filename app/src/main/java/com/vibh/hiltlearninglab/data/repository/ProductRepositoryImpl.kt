package com.vibh.hiltlearninglab.data.repository

import com.vibh.hiltlearninglab.data.model.Product
import com.vibh.hiltlearninglab.data.source.ProductDataSource
import javax.inject.Inject

class ProductRepositoryImpl @Inject constructor(
    private val productDataSource: ProductDataSource
): ProductRepository {
    override fun getProducts(): List<Product> {
        return productDataSource.getProducts()
    }
}