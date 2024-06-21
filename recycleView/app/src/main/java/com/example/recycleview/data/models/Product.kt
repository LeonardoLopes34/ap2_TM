package com.example.recycleview.data.models

import java.io.Serializable

data class Product(
    val urlImage: String,
    val name: String,
    val price: String,
    val description: String
) : Serializable

