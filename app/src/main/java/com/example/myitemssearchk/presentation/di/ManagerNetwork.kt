package com.example.myitemssearchk.presentation.di

import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.moshi.MoshiConverterFactory

class ManagerNetwork {

    private fun getOkHttpClientBuilder(): OkHttpClient {

        val okHttpClientBuilder = OkHttpClient.Builder()
            .addInterceptor { chain ->
                val defaultRequest = chain.request()
                val defaultHttpUrl = defaultRequest.url()
                val httpUrl = defaultHttpUrl.newBuilder().build()
                val requestBuilder = defaultRequest.newBuilder().url(httpUrl)
                chain.proceed(requestBuilder.build())
            }
        return okHttpClientBuilder.build()
    }

    fun createWebService(): Retrofit {
        val moshi: Moshi = Moshi
            .Builder()
            .add(KotlinJsonAdapterFactory())
            .build()

        return Retrofit.Builder()
            .baseUrl(BASE_URL)
            .client(getOkHttpClientBuilder())
            .addConverterFactory(MoshiConverterFactory.create(moshi))
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .build()
    }

    companion object {
        private const val BASE_URL = "https://api.mercadolibre.com/"
        const val RETROFIT_API = "retrofitApi"
    }
}
