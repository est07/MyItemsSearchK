package com.example.myitemssearchk.presentation

import android.app.Application
import com.example.myitemssearchk.presentation.di.mapperServiceModule
import com.example.myitemssearchk.presentation.di.repositoriesModule
import com.example.myitemssearchk.presentation.di.serviceModule
import com.example.myitemssearchk.presentation.di.useCasesModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.loadKoinModules
import org.koin.core.context.startKoin

class MyItemsSearchApplication : Application() {

    override fun onCreate() {
        super.onCreate()

        startKoin {
            androidContext(this@MyItemsSearchApplication)
            loadKoinModules(
                listOf(
                    serviceModule,
                    mapperServiceModule,
                    repositoriesModule,
                    useCasesModule
                )
            )
        }
    }
}
