package com.example.myitemssearchk.data.service.response

import com.squareup.moshi.Json

data class ItemResponse(
    @Json(name = "id")
    val id: String,
    @Json(name = "title")
    val title: String,
    @Json(name = "price")
    val price: Long,
    @Json(name = "permalink")
    val descriptionLink: String,
    @Json(name = "thumbnail")
    val thumbnail: String,
    @Json(name = "seller_address")
    val sellerAddress: SellerAddressResponse
)

data class SellerAddressResponse(
    @Json(name = "country")
    val country: Country,
    @Json(name = "state")
    val state: State,
    @Json(name = "city")
    val city: City
)

data class Country(
    @Json(name = "name")
    val countryName: String
)

data class State(
    @Json(name = "name")
    val stateName: String
)

data class City(
    @Json(name = "name")
    val cityName: String
)
