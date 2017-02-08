package ru.rambler.it.data.network

import ru.rambler.it.data.dbo.EventDbo
import rx.Observable
import java.util.*

interface NetworkDataProvider {

    fun getAllEvents(): Observable<List<EventDbo>>

    fun getEventsFromDate(modificationDate: Date): Observable<List<EventDbo>>
}