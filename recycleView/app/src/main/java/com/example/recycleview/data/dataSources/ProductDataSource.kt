package com.example.recycleview.data.dataSources

import com.example.recycleview.data.dataBase.ProductDao
import com.example.recycleview.data.dataBase.ProductEntity
import com.example.recycleview.data.models.Product
import javax.inject.Inject

class ProductDataSource @Inject constructor(private val productDao: ProductDao) {
    fun fetchAllProducts(): List<ProductEntity> = productDao.fetchAllProducts()

    suspend fun addProduct(productEntity: ProductEntity) = productDao.addProduct(productEntity)

    suspend fun deleteProduct(productName: String) = productDao.deleteProduct(productName)
}