package com.example.myitemssearchk.presentation.di

import com.example.myitemssearchk.domain.useCases.ItemSearchUC
import org.koin.dsl.module

val useCasesModule = module {
    factory { ItemSearchUC(itemSearchRepository = get()) }
}
