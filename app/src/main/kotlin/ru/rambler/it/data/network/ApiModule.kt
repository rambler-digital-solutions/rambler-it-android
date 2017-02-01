package ru.rambler.it.data.network

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


object ApiModule {
    val itRamblerApi: ITRamblerApi = Retrofit.Builder()
                .baseUrl("http://it.rambler-co.ru/")
                .addConverterFactory(GsonConverterFactory.create())
                .build()
                .create(ITRamblerApi::class.java)
}
