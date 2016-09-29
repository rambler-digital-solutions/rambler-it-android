package ru.rambler.it.data.network

import ru.rambler.it.data.dto.Event
import rx.Observable
import rx.schedulers.Schedulers
import java.util.*

class NetworkDataProviderImpl(val api: ITRamblerApi) : NetworkDataProvider {

    override fun getAllEvents(): Observable<List<Event>> = api.getAllEvents()
                .subscribeOn(Schedulers.io())
                .map { it.data }


    override fun getEventsFromDate(modificationDate: Date): Observable<List<Event>>
            = api.getEventsModifiedSince(modificationDate.time)
            .subscribeOn(Schedulers.io())
            .map { it.data }
}