package com.example.myitemssearchk.domain.useCases

import com.example.myitemssearchk.domain.repositories.ItemSearchRepository

class ItemSearchUC(private val itemSearchRepository: ItemSearchRepository) {

    fun getItemSearch(search: String) = itemSearchRepository.getItemSearch(search)
}
