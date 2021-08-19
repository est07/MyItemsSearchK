package com.example.myitemssearchk.presentation.di

import androidx.lifecycle.MutableLiveData
import com.example.myitemssearchk.presentation.viewModels.ItemSearchViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val viewModelModule = module {

    viewModel {
        ItemSearchViewModel(itemSearchUC = get(), _itemSearchState = MutableLiveData())
    }
}
