package com.example.myitemssearchk.domain.model

data class ItemSearch(
    val id: String,
    val title: String,
    val price: Long,
    val descriptionLink: String,
    val itemImage: String,
    val countryName: String,
    val cityName: String,
    val neighborhoodName: String
)
