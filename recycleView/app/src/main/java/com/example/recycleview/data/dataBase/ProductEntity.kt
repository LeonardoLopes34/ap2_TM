package com.example.recycleview.data.dataBase

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.recycleview.data.models.Product

@Entity(tableName = "products")
data class ProductEntity(
    @PrimaryKey(autoGenerate = true)
    val id: Int = 0,
    val name: String,
    val price: String,
    val description: String,
    val urlImage: String
)

fun ProductEntity.toMapperToProduct() = Product(name = this.name, urlImage = this.urlImage, price = this.price, description = this.description)



