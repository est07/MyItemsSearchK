package com.example.myitemssearchk.presentation.di

import com.example.myitemssearchk.data.mapper.ItemSearchMapperService
import org.koin.dsl.module

val mapperServiceModule = module {
    factory { ItemSearchMapperService() }
}
