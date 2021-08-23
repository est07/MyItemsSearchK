package com.example.myitemssearchk.data.mapper

import com.example.myitemssearchk.BaseTest
import com.example.myitemssearchk.data.service.response.City
import com.example.myitemssearchk.data.service.response.Country
import com.example.myitemssearchk.data.service.response.ItemResponse
import com.example.myitemssearchk.data.service.response.SellerAddressResponse
import com.example.myitemssearchk.data.service.response.State
import org.junit.Test
import org.junit.Assert.assertEquals

class ItemSearchMapperServiceTest : BaseTest() {

    private val itemSearchMapperService = ItemSearchMapperService()

    @Test
    fun testTransform() {

        val itemSearchResponse =
            ItemResponse(
                id = "id",
                title = "title",
                price = 11110,
                descriptionLink = "descriptionLink",
                thumbnail = "itemImage",
                sellerAddress = SellerAddressResponse(
                    country = Country(countryName = "countryName"),
                    state = State(stateName = "cityName"),
                    city = City(cityName = "neighborhoodName")
                )
            )

        val itemSearch = itemSearchMapperService.transform(itemSearchResponse)

        assertEquals(itemSearch.id, "id")
        assertEquals(itemSearch.title, "title")
        assertEquals(itemSearch.price, 11110)
        assertEquals(itemSearch.descriptionLink, "descriptionLink")
        assertEquals(itemSearch.itemImage, "itemImage")
        assertEquals(itemSearch.countryName, "countryName")
        assertEquals(itemSearch.cityName, "cityName")
        assertEquals(itemSearch.neighborhoodName, "neighborhoodName")
    }
}
