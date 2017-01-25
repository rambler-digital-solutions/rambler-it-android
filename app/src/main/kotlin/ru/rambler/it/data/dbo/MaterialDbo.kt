package ru.rambler.it.data.dbo

import io.realm.RealmObject
import io.realm.annotations.PrimaryKey

open class MaterialDbo(@PrimaryKey open var id: Int = 0,
                       open var title: String? = null,
                       open var link: String? = null,
                       open var kind: String? = null
) : RealmObject() { }