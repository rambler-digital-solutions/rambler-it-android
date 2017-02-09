package ru.rambler.it.data.dbo

import io.realm.RealmList
import io.realm.RealmObject
import java.util.*

open class EventAttributesDbo(open var name: String? = null,
                              open var kind: String? = null,
                              open var startDate: Date? = null,
                              open var endDate: Date? = null,
                              open var updateDate: Date? = null,
                              open var deleteDate: Date? = null,
                              open var deleted: Boolean? = false,
                              open var brand: BrandDbo? = null,
                              open var tech: TechDbo? = null,
                              open var lectures: RealmList<LectureDbo>? = null
) : RealmObject () { }
