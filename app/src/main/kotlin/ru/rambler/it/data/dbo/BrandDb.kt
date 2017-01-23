package ru.rambler.it.data.dbo

import io.realm.RealmObject
import io.realm.annotations.PrimaryKey

open class BrandDb(@PrimaryKey open var id: Int = 0,
                   open var name: String? = null,
                   open var description: String? = null,
                   open var homePage: String? = null,
                   open var logo: String? = null
) : RealmObject () { }