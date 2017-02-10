package ru.rambler.it.data.mappers

import ru.rambler.it.data.dbo.EventDbo
import ru.rambler.it.data.dto.EventDto
import ru.rambler.it.domain.entities.Event

class EventMapper : DataMapper<Event, EventDto, EventDbo> {

    private val eventAttributesMapper = EventAttributesMapper()

    override fun mapToDbo(entity: Event): EventDbo {
        return EventDbo(entity.id, entity.type, entity.attributes?.let { eventAttributesMapper.mapToDbo(it) })
    }

    override fun mapDto(dto: EventDto): Event {
        return Event(dto.id, dto.type, dto.attributes?.let { eventAttributesMapper.mapDto(it) })
    }

    override fun mapFromDbo(dbo: EventDbo): Event {
        return Event(dbo.id, dbo.type, dbo.attributes?.let { eventAttributesMapper.mapFromDbo(it) })
    }
}