package ru.rambler.it.data.mappers

import io.realm.RealmList
import ru.rambler.it.data.dbo.EventAttributesDbo
import ru.rambler.it.data.dbo.LectureDbo
import ru.rambler.it.data.dto.EventAttributesDto
import ru.rambler.it.domain.entities.EventAttributes
import ru.rambler.it.domain.entities.Lecture
import java.util.*


class EventAttributesMapper : DataMapper<EventAttributes, EventAttributesDto, EventAttributesDbo>{

    private val brandMapper = BrandMapper()
    private val techMapper = TechMapper()
    private val lectureMapper = LectureMapper()

    override fun mapToDbo(entity: EventAttributes): EventAttributesDbo {
        val lectureList = RealmList<LectureDbo>()
        entity.lectures?.mapTo(lectureList){ lectureMapper.mapToDbo(it) }

        return EventAttributesDbo(entity.name, entity.kind, entity.startDate, entity.endDate, entity.updateDate, entity.deleteDate,
                entity.deleted, entity.brand?.let { brandMapper.mapToDbo(it) }, entity.tech?.let { techMapper.mapToDbo(it) }, lectureList)
    }

    override fun mapDto(dto: EventAttributesDto): EventAttributes {
        val lectureList = ArrayList<Lecture>()
        dto.lectures?.mapTo(lectureList){ lectureMapper.mapDto(it) }

        return EventAttributes(dto.name, dto.kind, dto.startDate, dto.endDate, dto.updateDate, dto.deleteDate,
                dto.deleted, dto.brand?.let { brandMapper.mapDto(it) }, dto.tech?.let { techMapper.mapDto(it) }, lectureList)
    }

    override fun mapFromDbo(dbo: EventAttributesDbo): EventAttributes {
        val lectureList = ArrayList<Lecture>()
        dbo.lectures?.mapTo(lectureList){ lectureMapper.mapFromDbo(it) }

        return EventAttributes(dbo.name, dbo.kind, dbo.startDate, dbo.endDate, dbo.updateDate, dbo.deleteDate,
                dbo.deleted, dbo.brand?.let { brandMapper.mapFromDbo(it) }, dbo.tech?.let { techMapper.mapFromDbo(it) }, lectureList)
    }
}