package com.example.myitemssearchk.repositories

import com.example.myitemssearchk.BaseTest
import com.example.myitemssearchk.data.mapper.ItemSearchMapperService
import com.example.myitemssearchk.data.service.api.MercadoLibreApi
import com.example.myitemssearchk.data.service.response.City
import com.example.myitemssearchk.data.service.response.Country
import com.example.myitemssearchk.data.service.response.ItemResponse
import com.example.myitemssearchk.data.service.response.ItemSearchResponse
import com.example.myitemssearchk.data.service.response.SellerAddressResponse
import com.example.myitemssearchk.data.service.response.State
import com.example.myitemssearchk.domain.model.ItemSearch
import io.reactivex.Single
import org.junit.Before
import org.junit.Test
import org.mockito.Mock
import org.mockito.Mockito.doReturn
import org.mockito.Mockito.`when`
import org.mockito.Mockito.verify
import org.mockito.Mockito.verifyNoMoreInteractions
import org.mockito.MockitoAnnotations

class ItemSearchRepositoryImplTest : BaseTest() {

    @Mock
    private lateinit var api: MercadoLibreApi

    @Mock
    private lateinit var mapper: ItemSearchMapperService

    private lateinit var itemSearchRepositoryImpl: ItemSearchRepositoryImpl

    @Before
    fun setUp() {
        MockitoAnnotations.openMocks(this)

        itemSearchRepositoryImpl =
            ItemSearchRepositoryImpl(api, mapper)
    }

    @Test
    fun getItemSearch() {

        val listItemSearchResponse: ItemSearchResponse = mock()

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

        `when`(listItemSearchResponse.results).thenReturn(listOf(itemSearchResponse))
        doReturn(Single.just(listItemSearchResponse))
            .`when`(api).getItemSearch(search = "data")

        val itemSearch =
            ItemSearch(
                id = "id",
                title = "title",
                price = 11110,
                descriptionLink = "descriptionLink",
                itemImage = "itemImage",
                countryName = "countryName",
                cityName = "cityName",
                neighborhoodName = "neighborhoodName"
            )

        `when`(mapper.transform(itemSearchResponse)).thenReturn(itemSearch)

        val testObserver = itemSearchRepositoryImpl.getItemSearch(search = "data").test()
        testObserver.assertValue(listOf(itemSearch))

        verify(api).getItemSearch(search = "data")
        verify(listItemSearchResponse).results
        verify(mapper).transform(itemSearchResponse)
        verifyNoMoreInteractions(api, mapper, listItemSearchResponse)
    }
}
