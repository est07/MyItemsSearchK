package com.example.myitemssearchk.presentation.viewModels

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.myitemssearchk.commos.BaseViewModel
import com.example.myitemssearchk.domain.useCases.ItemSearchUC
import com.example.myitemssearchk.presentation.states.ItemSearchState
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

class ItemSearchViewModel(
    private val itemSearchUC: ItemSearchUC,
    private val _itemSearchState: MutableLiveData<ItemSearchState>,
) : BaseViewModel() {

    val getItemSearchStateLiveData: LiveData<ItemSearchState>
        get() = _itemSearchState

    fun getItemSearch(search: String) {
        addDisposable(
            itemSearchUC.getItemSearch(search)
                .doOnSubscribe { _itemSearchState.postValue(ItemSearchState.Loading) }
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe({
                    _itemSearchState.value = ItemSearchState.Success(it)
                }, {
                    _itemSearchState.value = ItemSearchState.Error
                })
        )
    }
}
