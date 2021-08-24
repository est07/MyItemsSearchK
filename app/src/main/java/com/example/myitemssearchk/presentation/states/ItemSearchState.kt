package com.example.myitemssearchk.presentation.states

import com.example.myitemssearchk.domain.model.ItemSearch

sealed class ItemSearchState {
    data class Success(val item: List<ItemSearch>) : ItemSearchState()
    object Loading : ItemSearchState()
    object Error : ItemSearchState()
}
