package ru.rambler.it.data.cache

import io.realm.Realm
import io.realm.RealmObject
import ru.rambler.it.data.dto.ParentDto
import rx.Observable

class CacheProvider : RealmObjectProvider {

    override fun mapToCache(data: Observable<List<out ParentDto>>): Observable<List<out RealmObject>> = data
            .flatMapIterable { it }
            .map { mapDto(it) }
            .toList()
            .map { it }


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