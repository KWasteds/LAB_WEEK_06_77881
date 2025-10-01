package com.example.lab_week_06_77881.model

import android.widget.ImageView
import com.bumptech.glide.Glide
import android.content.Context

class GlideImageLoader(private val context: Context) : ImageLoader{
    override fun loadImage(imageUrl: String, imageView: ImageView) {
        Glide.with(context)
        .load(imageUrl)
        .centerCrop()
        .into(imageView)
    }
}
