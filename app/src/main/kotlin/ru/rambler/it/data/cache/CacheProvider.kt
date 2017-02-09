package ru.rambler.it.data.cache

import ru.rambler.it.domain.entities.Event
import rx.Observable


interface CacheProvider {

    fun saveEvents(data: List<Event>): Observable<List<Event>>

    fun getEventsFromCache(): Observable<List<Event>>

}