package ru.rambler.it.data.cache

import io.realm.Realm
import io.realm.RealmObject
import ru.rambler.it.data.dbo.EventDb
import ru.rambler.it.data.dto.Event
import rx.Observable

class CacheProvider : RealmObjectProvider {

    override fun mapToCache(data: Observable<List<Event>>): Observable<List<EventDb>> = data
            .flatMapIterable { it }
            .map {
                val eventDbo = EventDb()
                Mapper(it, eventDbo)
                eventDbo
            }
            .toList()


    override fun addRealmObject(data: RealmObject): Boolean {
        var realm = Realm.getDefaultInstance()
        try {
            realm.beginTransaction()
            realm.copyToRealmOrUpdate(data)
            realm.commitTransaction()
            return true
        } catch (e: Exception) {
            println(e)
            return false
        } finally {
            realm.close()
        }
    }

}