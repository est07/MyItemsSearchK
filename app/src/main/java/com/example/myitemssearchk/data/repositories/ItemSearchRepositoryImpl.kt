package com.example.myitemssearchk.data.repositories

import com.example.myitemssearchk.data.mapper.ItemSearchMapperService
import com.example.myitemssearchk.data.service.api.MercadoLibreApi
import com.example.myitemssearchk.domain.model.ItemSearch
import com.example.myitemssearchk.domain.repositories.ItemSearchRepository
import io.reactivex.Single

class ItemSearchRepositoryImpl(
    private val api: MercadoLibreApi,
    private val mapper: ItemSearchMapperService
) : ItemSearchRepository {

    override fun getItemSearch(search: String): Single<List<ItemSearch>> {
        return api.getItemSearch(search = search).map { response ->
            response.results.map { itemSearchResponse -> mapper.transform(itemSearchResponse) }
        }
    }
}
