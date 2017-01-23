package ru.rambler.it.data.dbo

import io.realm.RealmList
import io.realm.RealmObject
import java.util.*

open class EventAttributesDb(open var name: String? = null,
                             open var startDate: Date? = null,
                             open var endDate: Date? = null,
                             open var updateDate: Date? = null,
                             open var deleteDate: Date? = null,
                             open var deleted: Boolean = false,
                             open var brand: BrandDb? = null,
                             open var tech: TechDb? = null,
                             open var lectures: RealmList<LectureDb>? = null
) : RealmObject () { }
