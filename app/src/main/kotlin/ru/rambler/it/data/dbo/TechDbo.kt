package ru.rambler.it.data.dbo

import io.realm.RealmObject
import io.realm.annotations.PrimaryKey

open class TechDbo(@PrimaryKey open var id: Int = 0,
                   open var name: String? = null,
                   open var color: String? = null
) : RealmObject() { }