package com.example.recycleview.data.Repositories

import com.example.recycleview.data.dataBase.toMapperToProduct
import com.example.recycleview.data.dataSources.ProductDataSource
import com.example.recycleview.data.models.Product
import com.example.recycleview.data.models.toEntity
import javax.inject.Inject

class ProductRepository @Inject constructor(private val productDataSource: ProductDataSource){
    fun fetchAllProducts(): List<Product> = productDataSource.fetchAllProducts().map {item -> item.toMapperToProduct() }

    suspend fun addProduct(product: Product) {
        productDataSource.addProduct(product.toEntity())
    }
    suspend fun deleteProduct(product: Product) {
        productDataSource.deleteProduct(product.name)
    }
}