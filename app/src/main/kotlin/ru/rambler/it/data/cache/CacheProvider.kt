package ru.rambler.it.data.cache

import ru.rambler.it.data.dbo.EventDbo

import rx.Observable


interface CacheProvider {
    fun saveEvents(data: List<EventDbo>): Observable<List<EventDbo>>
    fun getEventsFromCache(): Observable<List<EventDbo>>
}