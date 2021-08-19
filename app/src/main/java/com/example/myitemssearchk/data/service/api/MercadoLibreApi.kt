package com.example.myitemssearchk.data.service.api

import com.example.myitemssearchk.data.service.response.ItemSearchResponse
import io.reactivex.Single
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface MercadoLibreApi {

    @GET("sites/{SITE_ID}/search")
    fun getItemSearch(
        @Path("SITE_ID") siteId: String? = "MCO",
        @Query("q") search: String,
    ): Single<ItemSearchResponse>
}