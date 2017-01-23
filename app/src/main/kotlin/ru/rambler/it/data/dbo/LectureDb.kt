package ru.rambler.it.data.dbo

import io.realm.RealmList
import io.realm.RealmObject
import io.realm.annotations.PrimaryKey


open class LectureDb(@PrimaryKey open var id: Int = 0,
                     open var title: String? = null,
                     open var description: String? = null,
                     open var tags: RealmList<TagDb>? = null,
                     open var materials: RealmList<MaterialDb>? = null,
                     open var speaker: SpeakerDb? = null
) : RealmObject() { }
