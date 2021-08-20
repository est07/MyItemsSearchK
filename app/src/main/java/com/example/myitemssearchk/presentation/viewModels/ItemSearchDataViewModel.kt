package com.example.myitemssearchk.presentation.viewModels

import com.example.myitemssearchk.commos.BaseViewModel
import com.example.myitemssearchk.domain.model.ItemSearch

class ItemSearchDataViewModel : BaseViewModel() {
    var textSearched = String()
    var itemData: ItemSearch? = null
}