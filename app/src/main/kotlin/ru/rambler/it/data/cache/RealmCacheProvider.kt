package ru.rambler.it.data.cache

import io.realm.Realm
import ru.rambler.it.data.dbo.EventDbo
import ru.rambler.it.data.mappers.EventMapper
import ru.rambler.it.domain.entities.Event
import rx.Observable
import java.util.*
import javax.inject.Inject

class RealmCacheProvider@Inject constructor(val eventMapper: EventMapper) : CacheProvider {

    override fun saveEvents(data: List<Event>): Observable<List<Event>> {
        val realm = Realm.getDefaultInstance()
        try {
            val dboList = ArrayList<EventDbo>()
            data.mapTo(dboList) { eventMapper.mapToDbo(it) }
            realm.beginTransaction()
            realm.copyToRealmOrUpdate(dboList)
            realm.commitTransaction()
        } catch (e: Exception) {
            println(e)
        } finally {
            realm.close()
            return getEventsFromCache()
        }
    }

    override fun getEventsFromCache(): Observable<List<Event>> {
        val result = ArrayList<Event>()
        val realm = Realm.getDefaultInstance()
        try {
            realm.where(EventDbo::class.java)
                    .findAllAsync()
                    .mapTo(result) { eventMapper.mapFromDbo(it) }
        } catch (e: Exception) {
            println(e)
        } finally {
            realm.close()
            return Observable.just(result)
        }
    }
}