package ru.rambler.it.data.network

import retrofit2.Retrofit
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import ru.rambler.it.data.mappers.EventMapper
import ru.rambler.it.domain.entities.Event
import rx.Observable
import java.util.*
import javax.inject.Inject

class NetworkDataProviderImpl @Inject constructor(val eventMapper: EventMapper) : NetworkDataProvider {

    val api: ITRamblerApi = Retrofit.Builder()
            .baseUrl("http://it.rambler-co.ru/api/")
            .addConverterFactory(GsonConverterFactory.create())
            .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
            .build()
            .create(ITRamblerApi::class.java)

    override fun getAllEvents(): Observable<List<Event>> = api.getAllEvents()
                .map { it.data.map { eventMapper.mapDto(it) }}


    override fun getEventsFromDate(modificationDate: Date): Observable<List<Event>>
            = api.getEventsModifiedSince(modificationDate.time)
            .map { it.data.map { eventMapper.mapDto(it) }}
}