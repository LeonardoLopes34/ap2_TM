package com.example.recycleview.commons.utils

fun String.convertToMoney() = "R$ " .plus(this.replace(".", ","))