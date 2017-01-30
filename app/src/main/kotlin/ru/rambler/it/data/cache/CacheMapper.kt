package ru.rambler.it.data.cache

import io.realm.RealmList
import io.realm.RealmObject
import ru.rambler.it.data.dbo.*
import ru.rambler.it.data.dto.*
import java.lang.reflect.Field
import java.util.*


fun mapToDbo(data: List<out ParentDto>): List<out RealmObject> = data
        .map(::mapDto)

private fun mapDto(source: ParentDto): RealmObject {
    val dest: RealmObject = makeDbo(source) ?: throw Exception("FUN makeDbo FAILED")

    val sourceClass: Class<Any> = source.javaClass
    val destClass: Class<Any> = dest.javaClass

    val destFields: Array<Field> = destClass.declaredFields;
    val destFieldsMap = HashMap<String, Field>(destFields.size)
    for (f in destFields) {
        destFieldsMap.put(f.name, f)
        f.isAccessible = true
    }

    val sourceFields = sourceClass.declaredFields
    val assignableSourceFieldsMap: MutableMap<String, Field> = HashMap(sourceFields.size)
    val notAssignableSourceFieldsMap: MutableMap<String, Field> = HashMap()
    for (sf in sourceFields) {
        val df = destFieldsMap[sf.getName()]
        if (df != null) {
            if (df.type.isAssignableFrom(sf.type)) {
                assignableSourceFieldsMap.put(sf.name, sf)
            } else {
                notAssignableSourceFieldsMap.put(sf.name, sf)
            }
            sf.setAccessible(true)
        }
    }

    for (destField in destFields) {
        var sourceField: Field? = assignableSourceFieldsMap[destField.name]
        if (sourceField != null) {
            try {
                destField.set(dest, sourceField.get(source))
            } catch (e: IllegalAccessException) {
                e.printStackTrace()
            }

        } else {
            sourceField = notAssignableSourceFieldsMap[destField.name]
            if (sourceField != null) {
                val sourceInnerObject = sourceField.get(source)
                if (sourceInnerObject is ParentDto) {
                    val destInnerObject = mapDto(sourceInnerObject)
                    destField.set(dest, destInnerObject)
                } else if (sourceInnerObject is List<*> && sourceInnerObject.size > 0 && sourceInnerObject[0] is ParentDto) {
                    val destInnerList = RealmList<RealmObject>()
                    sourceInnerObject.mapTo(destInnerList) { mapDto(it as ParentDto) }
                    destField.set(dest, destInnerList)
                }
            }
        }
    }

    return dest
}

private fun makeDbo(dto: ParentDto): RealmObject? {
    when (dto) {
        is Brand -> return BrandDbo()
        is Event -> return EventDbo()
        is EventAttributes -> return EventAttributesDbo()
        is EventsCollection -> return EventsCollectionDbo()
        is Lecture -> return LectureDbo()
        is Material -> return MaterialDbo()
        is SocialProfile -> return SocialProfileDbo()
        is Speaker -> return SpeakerDbo()
        is Tag -> return TagDbo()
        is Tech -> return TechDbo()
        else -> return null
    }
}