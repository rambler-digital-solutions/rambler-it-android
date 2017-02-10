package ru.rambler.it.data.cache

import io.realm.Realm
import ru.rambler.it.data.dbo.EventDbo
import ru.rambler.it.data.mappers.EventMapper
import ru.rambler.it.domain.entities.Event
import rx.Observable
import javax.inject.Inject

class RealmCacheProvider @Inject constructor(val eventMapper: EventMapper) : CacheProvider {


    override fun saveEvents(data: List<Event>): Observable<List<Event>> {
        return Observable.from(data)
                .map { eventMapper.mapToDbo(it) }
                .toList()
                .doOnNext {
                    val realm = Realm.getDefaultInstance()
                    realm.beginTransaction()
                    realm.copyToRealmOrUpdate(it)
                    realm.commitTransaction()
                    realm.close()
                }.flatMap { getEventsFromCache() }
    }

    override fun getEventsFromCache(): Observable<List<Event>> {
        return Observable.create<List<EventDbo>> {
                    val realm = Realm.getDefaultInstance()
                    try {
                        val all = realm.where(EventDbo::class.java)
                                .findAll()
                        it.onNext(all)
                        it.onCompleted()
                    } catch (e: Exception) {
                        it.onError(e)
                    }
                    realm.close()
                }
                .flatMapIterable {it}
                .map { eventMapper.mapFromDbo(it) }
                .toList()
    }
}