package ru.rambler.it.data.dbo

import io.realm.RealmList
import io.realm.RealmObject

open class EventsCollectionDbo(open var data: RealmList<EventDbo>? = null) : RealmObject() { }
