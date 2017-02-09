package ru.rambler.it.data.network

import ru.rambler.it.domain.entities.Event
import rx.Observable
import java.util.*

interface NetworkDataProvider {

    fun getAllEvents(): Observable<List<Event>>

    fun getEventsFromDate(modificationDate: Date): Observable<List<Event>>
}