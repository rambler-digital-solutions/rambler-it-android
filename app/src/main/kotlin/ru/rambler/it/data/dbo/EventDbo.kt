package ru.rambler.it.data.dbo

import io.realm.RealmObject
import io.realm.annotations.PrimaryKey

open class EventDbo(@PrimaryKey open var id: Int = 0,
                    open var type: String? = null,
                    open var attributes: EventAttributesDbo? = null
) : RealmObject() { }
