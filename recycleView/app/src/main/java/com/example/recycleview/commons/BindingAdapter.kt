package com.example.recycleview.commons

import android.widget.ImageView
import androidx.databinding.BindingAdapter
import com.bumptech.glide.Glide

object BindingAdapter {
    @BindingAdapter("app:loadImg")
    @JvmStatic
    fun loadImg(view: ImageView, url: String) {
        Glide.with(view.context)
            .load(url)
            .centerCrop()
            .into(view)
    }
}