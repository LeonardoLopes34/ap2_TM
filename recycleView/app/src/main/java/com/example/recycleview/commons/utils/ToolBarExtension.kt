package com.example.recycleview.commons.utils

import androidx.appcompat.app.AppCompatActivity


fun AppCompatActivity.configureToolbar(title: String, enableBackButton: Boolean) {
    supportActionBar?.apply {
        this.title = title
        setDisplayHomeAsUpEnabled(enableBackButton)
    }
}
