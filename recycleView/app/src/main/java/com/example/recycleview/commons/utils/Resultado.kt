package com.example.recycleview.commons.utils

sealed class Resultado<out T> {

    data object Loading: Resultado<Nothing>()

    data class Sucess<out T>(val data: T): Resultado<T>()

    data class Error(val exception: Exception): Resultado<Nothing>()
}