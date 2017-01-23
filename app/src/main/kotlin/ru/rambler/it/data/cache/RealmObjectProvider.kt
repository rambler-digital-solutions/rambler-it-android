package ru.rambler.it.data.cache

import io.realm.RealmObject
import ru.rambler.it.data.dbo.EventDb
import ru.rambler.it.data.dto.Event
import rx.Observable


interface RealmObjectProvider {
    fun addRealmObject(data: RealmObject): Boolean
    fun mapToCache(data: Observable<List<Event>>): Observable<List<EventDb>>
}