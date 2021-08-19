package com.example.myitemssearchk.data.mapper

import com.example.myitemssearchk.data.service.response.ItemResponse
import com.example.myitemssearchk.domain.model.ItemSearch

class ItemSearchMapperService : BaseMapperService<ItemResponse, ItemSearch> {

    override fun transform(type: ItemResponse): ItemSearch = ItemSearch(
        id = type.id,
        title = type.title,
        price = type.price,
        descriptionLink = type.descriptionLink,
        itemImage = type.thumbnail,
        countryName = type.sellerAddress.country.countryName,
        cityName = type.sellerAddress.state.stateName,
        neighborhoodName = type.sellerAddress.city.cityName,
    )
}
