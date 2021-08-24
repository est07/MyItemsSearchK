package com.example.myitemssearchk.domain.uc

import com.example.myitemssearchk.BaseTest
import com.example.myitemssearchk.domain.model.ItemSearch
import com.example.myitemssearchk.domain.repositories.ItemSearchRepository
import com.example.myitemssearchk.domain.useCases.ItemSearchUC
import io.reactivex.Single
import org.junit.Before
import org.junit.Test
import org.mockito.Mock
import org.mockito.Mockito.`when`
import org.mockito.Mockito.verify
import org.mockito.Mockito.verifyNoMoreInteractions
import org.mockito.MockitoAnnotations

class ItemSearchUCTest : BaseTest() {

    @Mock
    private lateinit var itemSearchRepository: ItemSearchRepository

    private lateinit var itemSearchUC: ItemSearchUC

    @Before
    fun setUp() {
        MockitoAnnotations.openMocks(this)

        itemSearchUC = ItemSearchUC(itemSearchRepository)
    }

    @Test
    fun getItemSearch() {
        val response: Single<List<ItemSearch>> = mock()

        `when`(itemSearchRepository.getItemSearch(search = "data")).thenReturn(response)

        itemSearchUC.getItemSearch(search = "data").test()

        verify(itemSearchRepository).getItemSearch(search = "data")
        verifyNoMoreInteractions(itemSearchRepository)
    }
}