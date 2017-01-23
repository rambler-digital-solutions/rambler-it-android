package ru.rambler.it.data.cache

import io.realm.RealmObject
import ru.rambler.it.data.dbo.*
import ru.rambler.it.data.dto.*


object TypesMap {

    fun makeDbo(dto: ParentDto): RealmObject? {
        when (dto) {
            is Brand -> return BrandDb()
            is Event -> return EventDb()
            is EventAttributes -> return EventAttributesDb()
            is EventsCollection -> return EventsCollectionDb()
            is Lecture -> return LectureDb()
            is Material -> return MaterialDb()
            is SocialProfile -> return SocialProfileDb()
            is Speaker -> return SpeakerDb()
            is Tag -> return TagDb()
            is Tech -> return TechDb()
            else -> return null
        }
    }
}