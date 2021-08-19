package com.example.myitemssearchk.presentation.di

import com.example.myitemssearchk.data.service.api.MercadoLibreApi
import com.example.myitemssearchk.presentation.di.ManagerNetwork.Companion.RETROFIT_API
import org.koin.core.qualifier.named
import org.koin.dsl.module
import retrofit2.Retrofit

val serviceModule = module {
    single(named(RETROFIT_API)) { ManagerNetwork().createWebService() }
    single { get<Retrofit>(named(RETROFIT_API)).create(MercadoLibreApi::class.java) }
}
