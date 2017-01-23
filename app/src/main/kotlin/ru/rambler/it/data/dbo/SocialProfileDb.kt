package ru.rambler.it.data.dbo

import io.realm.RealmObject

open class SocialProfileDb(open var network: String? = null,
                           open var link: String? = null
) : RealmObject () { }
