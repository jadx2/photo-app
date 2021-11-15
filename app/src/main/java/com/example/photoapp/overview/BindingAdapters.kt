package com.example.photoapp.overview

import android.widget.ImageView
import android.widget.TextView
import androidx.core.net.toUri
import androidx.databinding.BindingAdapter
import com.bumptech.glide.Glide
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.bumptech.glide.load.model.GlideUrl
import com.bumptech.glide.load.model.LazyHeaders
import com.bumptech.glide.request.RequestOptions
import com.example.photoapp.R

/***
 * Binding fot the imageView
 */
@BindingAdapter("imageUrl")
fun ImageView.bindImage(imgUrl: String?) {
    imgUrl?.let {
        val url = GlideUrl(
            it, LazyHeaders.Builder()
                .addHeader("User-Agent", "your-user-agent")
                .build()
        );
        Glide.with(this)
            .load(url)
            .diskCacheStrategy(DiskCacheStrategy.ALL)
            .apply(
                RequestOptions()
                    .placeholder(R.drawable.loading_animation)
                    .error(R.drawable.ic_broken_image)
            )
            .into(this)
    }
}

/***
 * Binding for the photo title
 */
@BindingAdapter("photoTitle")
fun TextView.bindText(title: String?) {
    title?.let {
        text = title
    }
}