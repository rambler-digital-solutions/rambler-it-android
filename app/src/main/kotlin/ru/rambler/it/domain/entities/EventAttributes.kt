package ru.rambler.it.domain.entities

import java.util.*

data class EventAttributes(val name: String?, val kind: String?,
                           val startDate: Date?,
                           val endDate: Date?,
                           val updateDate: Date?,
                           val deleteDate: Date?,
                           val deleted: Boolean? = false,
                           val brand: Brand?,
                           val tech: Tech?,
                           val lectures: List<Lecture>?) {
}