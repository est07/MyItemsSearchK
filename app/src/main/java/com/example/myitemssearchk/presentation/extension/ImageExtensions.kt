package com.example.myitemssearchk.presentation.extension

import android.widget.ImageView
import com.example.myitemssearchk.R
import com.squareup.picasso.Picasso

fun ImageView.getImageByUrl(url: String) {
    Picasso.with(context).load(url).error(R.drawable.ic_photo_120).into(this)
}