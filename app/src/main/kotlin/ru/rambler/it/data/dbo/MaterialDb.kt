package ru.rambler.it.data.dbo

import io.realm.RealmObject
import io.realm.annotations.PrimaryKey

/**
 * Created by alex.ivanov on 12.01.17.
 */

open class MaterialDb(@PrimaryKey open var id: Int = 0,
                     open var title: String? = null,
                     open var link: String? = null,
                     open var kind: String? = null
) : RealmObject() { }