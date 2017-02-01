package ru.rambler.it.data

import ru.rambler.it.data.cache.CacheProvider
import ru.rambler.it.data.cache.mapToDbo
import ru.rambler.it.data.dbo.EventDbo
import ru.rambler.it.data.dto.Event
import ru.rambler.it.data.network.ITRamblerApi
import ru.rambler.it.data.network.NetworkDataProviderImpl
import rx.Observable
import java.util.*
import javax.inject.Inject

class EventsInteractor(var cacheProvider: CacheProvider) {

    @Inject lateinit var itRamblerApi: ITRamblerApi

    val networkDataProvider = NetworkDataProviderImpl(itRamblerApi)

    fun getCachedEvents(): Observable<List<EventDbo>> {
        return cacheProvider.getEventsFromCache()
    }

    fun loadAllEvents() {
        networkDataProvider.getAllEvents().subscribe { saveEvents(it) }
    }

    fun loadEventsFromDate(date: Date) {
        networkDataProvider.getEventsFromDate(date).subscribe { saveEvents(it) }
    }

    private fun saveEvents(data: List<Event>) {
        cacheProvider.saveEvents(mapToDbo(data) as List<EventDbo>)
    }

}