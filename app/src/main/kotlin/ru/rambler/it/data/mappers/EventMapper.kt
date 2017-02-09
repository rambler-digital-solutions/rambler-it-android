package ru.rambler.it.data.mappers

import ru.rambler.it.data.dbo.EventDbo
import ru.rambler.it.domain.entities.Event

class EventMapper : DataMapper<Event, EventDbo> {

    private val eventAttributesMapper = EventAttributesMapper()

    override fun map(dto: Event): EventDbo {
        return EventDbo(dto.id, dto.type, eventAttributesMapper.map(dto.attributes))
    }
}