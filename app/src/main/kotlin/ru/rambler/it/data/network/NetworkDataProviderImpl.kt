package ru.rambler.it.data.network

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import ru.rambler.it.data.dbo.EventDbo
import ru.rambler.it.data.mappers.EventMapper

import rx.Observable
import rx.schedulers.Schedulers
import java.util.*

class NetworkDataProviderImpl(val eventMapper: EventMapper) : NetworkDataProvider {

    val api: ITRamblerApi = Retrofit.Builder()
    .baseUrl("http://it.rambler-co.ru/")
    .addConverterFactory(GsonConverterFactory.create())
    .build()
    .create(ITRamblerApi::class.java)

    override fun getAllEvents(): Observable<List<EventDbo>> = api.getAllEvents()
                .subscribeOn(Schedulers.io())
                .map { it.data.map { eventMapper.map(it) } }


    override fun getEventsFromDate(modificationDate: Date): Observable<List<EventDbo>>
            = api.getEventsModifiedSince(modificationDate.time)
            .subscribeOn(Schedulers.io())
            .map { it.data.map { eventMapper.map(it) } }
}