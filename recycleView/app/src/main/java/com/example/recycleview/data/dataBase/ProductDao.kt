package com.example.recycleview.data.dataBase

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import com.example.recycleview.data.models.Product

@Dao
interface ProductDao {
    @Query("SELECT * FROM products ")
    fun fetchAllProducts(): List<ProductEntity>

    @Insert
    suspend fun addProduct(productEntity: ProductEntity)

    @Query("DELETE FROM products WHERE name = :productName")
    suspend fun deleteProduct(productName: String)
}