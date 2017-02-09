package ru.rambler.it.data.network

import retrofit2.http.GET
import retrofit2.http.Query

import ru.rambler.it.data.dto.EventsCollectionDto
import rx.Observable

interface ITRamblerApi {

    @GET("events") fun getAllEvents(): Observable<EventsCollectionDto>

    @GET("events") fun getEventsModifiedSince(@Query("filter[modified_since]") modificationTimestamp: Long): Observable<EventsCollectionDto>
}