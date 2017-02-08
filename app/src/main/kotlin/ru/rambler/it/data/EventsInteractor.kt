package ru.rambler.it.data

import ru.rambler.it.data.cache.CacheProvider
import ru.rambler.it.data.dbo.EventDbo
import ru.rambler.it.data.dto.Event
import ru.rambler.it.data.mappers.EventMapper
import ru.rambler.it.data.network.NetworkDataProvider
import rx.Observable
import java.util.*
import javax.inject.Inject

class EventsInteractor() {

    @Inject lateinit var networkDataProvider: NetworkDataProvider
    @Inject lateinit var cacheProvider: CacheProvider
    @Inject lateinit var eventMapper: EventMapper

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
        val mappedData = ArrayList<EventDbo>()
        data.mapTo(mappedData){eventMapper.map(it)}
        cacheProvider.saveEvents(mappedData)
    }

}