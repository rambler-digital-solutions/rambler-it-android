package ru.rambler.it.data.dbo

import io.realm.RealmObject
import io.realm.annotations.PrimaryKey

/**
 * Created by alex.ivanov on 12.01.17.
 */

open class SpeakerDb(
        @PrimaryKey open var id: Int = 0,
        open var firstName: String? = null,
        open var lastName: String? = null,
        open var bio: String? = null,
        open var job: String? = null,
        open var company: String? = null,
        open var image: String? = null
) : RealmObject() { }