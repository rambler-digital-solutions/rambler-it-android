package ru.rambler.it.data.cache

import io.realm.RealmObject

import ru.rambler.it.data.dto.ParentDto
import rx.Observable


interface RealmObjectProvider {
    fun addRealmObject(data: RealmObject): Boolean
    fun mapToCache(data: Observable<List<out ParentDto>>): Observable<List<out RealmObject>>
}