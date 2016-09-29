package ru.rambler.it.data.network

import ru.rambler.it.data.dto.Event
import rx.Observable
import java.util.*

interface NetworkDataProvider {

    fun getAllEvents(): Observable<List<Event>>

    fun getEventsFromDate(modificationDate: Date): Observable<List<Event>>
}