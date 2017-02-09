package ru.rambler.it.data

import ru.rambler.it.data.cache.CacheProvider
import ru.rambler.it.data.network.NetworkDataProvider
import ru.rambler.it.domain.entities.Event
import rx.Observable
import java.util.*

class EventsInteractor(val networkDataProvider: NetworkDataProvider, val cacheProvider: CacheProvider) {

    fun getCachedEvents(): Observable<List<Event>> {
        return cacheProvider.getEventsFromCache()
    }

    fun loadAllEvents() {
        networkDataProvider.getAllEvents().subscribe { cacheProvider.saveEvents(it) }
    }

    fun loadEventsFromDate(date: Date) {
        networkDataProvider.getEventsFromDate(date).subscribe { cacheProvider.saveEvents(it) }
    }

}