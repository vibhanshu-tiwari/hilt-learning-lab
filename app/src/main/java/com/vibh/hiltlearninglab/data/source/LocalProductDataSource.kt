package com.vibh.hiltlearninglab.data.source

import com.vibh.hiltlearninglab.data.model.Product
import javax.inject.Inject

class LocalProductDataSource @Inject constructor() : ProductDataSource {
    override fun getProducts(): List<Product> {
        return listOf(
            Product(1, "Laptop", 999.99),
            Product(2, "Keyboard", 49.99),
            Product(3, "Mouse", 19.99),
            Product(4, "Monitor", 299.99)
        )
    }
}