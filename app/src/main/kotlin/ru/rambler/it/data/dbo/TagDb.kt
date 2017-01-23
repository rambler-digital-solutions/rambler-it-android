package ru.rambler.it.data.dbo

import io.realm.RealmObject
import io.realm.annotations.PrimaryKey

open class TagDb(@PrimaryKey open var id: Int = 0,
                      open var name: String? = null,
                      open var slug: String? = null
) : RealmObject() { }