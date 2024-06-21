package com.example.recycleview.data.dataBase

import androidx.room.Dao
import androidx.room.Query

@Dao
interface ProductDao {
    @Query("SELECT * FROM products ")
    fun fetchAllProducts(): List<ProductEntity>
}