package com.example.myitemssearchk.domain.repositories

import com.example.myitemssearchk.domain.ItemSearch
import io.reactivex.Single

interface ItemSearchRepository {

    fun getItemSearch(search: String): Single<List<ItemSearch>>
}
