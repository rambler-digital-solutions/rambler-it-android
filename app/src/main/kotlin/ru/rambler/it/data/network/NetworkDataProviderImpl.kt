package ru.rambler.it.data.network

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import ru.rambler.it.data.mappers.EventMapper
import ru.rambler.it.domain.entities.Event
import rx.Observable
import rx.schedulers.Schedulers
import java.util.*

class NetworkDataProviderImpl(val eventMapper: EventMapper) : NetworkDataProvider {

    val api: ITRamblerApi = Retrofit.Builder()
    .baseUrl("http://it.rambler-co.ru/api/")
    .addConverterFactory(GsonConverterFactory.create())
    .build()
    .create(ITRamblerApi::class.java)

    override fun getAllEvents(): Observable<List<Event>> = api.getAllEvents()
                .subscribeOn(Schedulers.io())
                .map { it.data.map { eventMapper.mapDto(it) }}


    override fun getEventsFromDate(modificationDate: Date): Observable<List<Event>>
            = api.getEventsModifiedSince(modificationDate.time)
            .subscribeOn(Schedulers.io())
            .map { it.data.map { eventMapper.mapDto(it) }}
}