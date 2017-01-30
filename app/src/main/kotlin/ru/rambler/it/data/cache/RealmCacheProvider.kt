package ru.rambler.it.data.cache

import io.realm.Realm
import ru.rambler.it.data.dbo.EventDbo
import rx.Observable
import java.util.*

class RealmCacheProvider : CacheProvider {

    override fun saveEvents(data: List<EventDbo>): Observable<List<EventDbo>> {
        val realm = Realm.getDefaultInstance()
        try {
            realm.beginTransaction()
            realm.copyToRealmOrUpdate(data)
            realm.commitTransaction()
            return Observable.just(data)
        } catch (e: Exception) {
            println(e)
            return Observable.just(ArrayList<EventDbo>())
        } finally {
            realm.close()
        }
    }

    override fun getEventsFromCache(): Observable<List<EventDbo>> {
        val realm = Realm.getDefaultInstance()
        return realm.where(EventDbo::class.java).findAllAsync().asObservable().map { it }
    }
}