package ru.rambler.it.data.dbo

import io.realm.RealmList
import io.realm.RealmObject
import io.realm.annotations.PrimaryKey


open class LectureDbo(@PrimaryKey open var id: Int = 0,
                      open var title: String? = null,
                      open var description: String? = null,
                      open var tags: RealmList<TagDbo>? = null,
                      open var materials: RealmList<MaterialDbo>? = null,
                      open var speaker: SpeakerDbo? = null
) : RealmObject() { }
