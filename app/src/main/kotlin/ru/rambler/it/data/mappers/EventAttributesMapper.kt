package ru.rambler.it.data.mappers

import io.realm.RealmList
import ru.rambler.it.data.dbo.EventAttributesDbo
import ru.rambler.it.data.dbo.LectureDbo
import ru.rambler.it.data.dto.EventAttributes
import javax.inject.Inject


class EventAttributesMapper : DataMapper<EventAttributes, EventAttributesDbo>{

    @Inject lateinit var brandMapper: BrandMapper
    @Inject lateinit var techMapper: TechMapper
    @Inject lateinit var lectureMapper: LectureMapper

    override fun map(dto: EventAttributes): EventAttributesDbo {
        val lectureList = RealmList<LectureDbo>()
        dto.lectures.mapTo(lectureList){ lectureMapper.map(it) }

        return EventAttributesDbo(dto.name, dto.startDate, dto.endDate, dto.updateDate, dto.deleteDate,
                dto.deleted, brandMapper.map(dto.brand), techMapper.map(dto.tech), lectureList)
    }
}