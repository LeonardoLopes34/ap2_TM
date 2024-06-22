package com.example.recycleview.data.models

import com.example.recycleview.data.dataBase.ProductEntity
import java.io.Serializable

data class Product(
    val urlImage: String,
    val name: String,
    val price: String,
    val description: String
) : Serializable

fun Product.toEntity() = ProductEntity(name = this.name, price = this.price, urlImage = this.urlImage, description = this.description)
