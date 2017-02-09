package ru.rambler.it.data.cache

import ru.rambler.it.domain.entities.Event
import rx.Observable
import java.util.*
import javax.inject.Inject

class RealmCacheProvider @Inject constructor () : CacheProvider {

    override fun saveEvents(data: List<Event>): Observable<List<Event>> {
//        val realm = Realm.getDefaultInstance()
//        try {
//            realm.beginTransaction()
//            realm.copyToRealmOrUpdate(data)
//            realm.commitTransaction()
//            return Observable.just(data)
//        } catch (e: Exception) {
//            println(e)
//            return Observable.just(ArrayList<Event>())
//        } finally {
//            realm.close()
//        }
        return Observable.just(ArrayList<Event>())
    }

    override fun getEventsFromCache(): Observable<List<Event>> {
//        val realm = Realm.getDefaultInstance()
//        return realm.where(EventDbo::class.java)
//                .findAllAsync()
//                .asObservable()
//                .map { realm.copyFromRealm(it) }
                    return Observable.just(ArrayList<Event>())

    }
}