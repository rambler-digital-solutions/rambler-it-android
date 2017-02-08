package ru.rambler.it.data

import ru.rambler.it.data.cache.CacheProvider
import ru.rambler.it.data.dbo.EventDbo
import ru.rambler.it.data.network.NetworkDataProvider
import rx.Observable
import java.util.*

class EventsInteractor(val networkDataProvider: NetworkDataProvider, val cacheProvider: CacheProvider) {

    fun getCachedEvents(): Observable<List<EventDbo>> {
        return cacheProvider.getEventsFromCache()
    }

    fun loadAllEvents() {
        networkDataProvider.getAllEvents().subscribe { cacheProvider.saveEvents(it) }
    }

    fun loadEventsFromDate(date: Date) {
        networkDataProvider.getEventsFromDate(date).subscribe { cacheProvider.saveEvents(it) }
    }

}