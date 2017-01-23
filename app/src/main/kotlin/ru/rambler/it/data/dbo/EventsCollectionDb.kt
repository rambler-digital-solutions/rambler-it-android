package ru.rambler.it.data.dbo

import io.realm.RealmList
import io.realm.RealmObject

open class EventsCollectionDb(open var data: RealmList<EventDb>? = null) : RealmObject() { }
