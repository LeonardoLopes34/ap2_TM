package com.example.recycleview

fun String.convertToMoney() = "R$ " .plus(this.replace(".", ","))