package com.example.myitemssearchk.presentation.viewModels

import androidx.lifecycle.MutableLiveData
import com.example.myitemssearchk.BaseTest
import com.example.myitemssearchk.domain.model.ItemSearch
import com.example.myitemssearchk.domain.useCases.ItemSearchUC
import com.example.myitemssearchk.presentation.states.ItemSearchState
import io.reactivex.Single
import org.junit.After
import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Test
import org.mockito.Mockito.`when`
import org.mockito.Mockito.verify
import org.mockito.Mockito.verifyNoMoreInteractions

class ItemSearchViewModelTest : BaseTest() {

    private val itemSearchUC: ItemSearchUC = mock()
    private val _itemSearchState: MutableLiveData<ItemSearchState> = mock()

    private lateinit var itemSearchViewModel: ItemSearchViewModel

    @Before
    fun setUp() {
        itemSearchViewModel = ItemSearchViewModel(
            itemSearchUC,
            _itemSearchState
        )
    }

    @After
    fun tearDown() {
        verifyNoMoreInteractions(
            itemSearchUC,
            _itemSearchState
        )
    }

    @Test
    fun getGetItemSearchStateLiveData() {
        assertEquals(
            itemSearchViewModel.getItemSearchStateLiveData,
            _itemSearchState
        )
    }

    @Test
    fun `getItemSearch success`() {
        val listItemSearchResult: List<ItemSearch> = mock()

        `when`(
            itemSearchUC.getItemSearch("search"))
            .thenReturn(
                Single.just(listItemSearchResult)
            )

        itemSearchViewModel.getItemSearch("search")

        verify(_itemSearchState).postValue(ItemSearchState.Loading)
        verify(itemSearchUC).getItemSearch("search")
        verify(_itemSearchState).value = ItemSearchState.Success(listItemSearchResult)
        verifyNoMoreInteractions(listItemSearchResult)
    }

    @Test
    fun `getItemSearch error`() {
        val throwable: Throwable = mock()

        `when`(itemSearchUC.getItemSearch("search"))
            .thenReturn(
                Single.error(throwable)
            )

        itemSearchViewModel.getItemSearch("search")

        verify(_itemSearchState).postValue(ItemSearchState.Loading)
        verify(itemSearchUC).getItemSearch("search")
        verify(_itemSearchState).value = ItemSearchState.Error
        verifyNoMoreInteractions(throwable)
    }
}
