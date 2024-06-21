package com.example.recycleview.data.dataBase

import androidx.room.Database

@Database(entities = [ProductEntity::class], version = 1, exportSchema = false)
abstract class AppDataBase {
    abstract fun productDao(): ProductDao
}