package com.example.myitemssearchk.presentation.di

import com.example.myitemssearchk.repositories.ItemSearchRepositoryImpl
import com.example.myitemssearchk.domain.repositories.ItemSearchRepository
import org.koin.dsl.module

val repositoriesModule = module {
    factory<ItemSearchRepository> { ItemSearchRepositoryImpl(api = get(), mapper = get()) }
}