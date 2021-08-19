package com.example.myitemssearchk.domain.uc

import com.example.myitemssearchk.domain.repositories.ItemSearchRepository

class ItemSearchUC(private val itemSearchRepository: ItemSearchRepository) {

    fun getMealSearch(search: String) = itemSearchRepository.getItemSearch(search)
}
