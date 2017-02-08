package ru.rambler.it.data.mappers

import ru.rambler.it.data.dbo.EventDbo
import ru.rambler.it.data.dto.Event
import ru.rambler.it.other.di.component.DaggerMainScreenComponent
import ru.rambler.it.other.di.component.DaggerMapperComponent
import ru.rambler.it.other.di.getAppComponent
import ru.rambler.it.other.di.getMapperComponent
import ru.rambler.it.other.di.initializeMapperComponent
import ru.rambler.it.other.di.module.MainScreenModule
import ru.rambler.it.other.di.module.MapperModule
import javax.inject.Inject

class EventMapper : DataMapper<Event, EventDbo> {

    @Inject lateinit var eventAttributesMapper: EventAttributesMapper

    override fun map(dto: Event): EventDbo {
        return EventDbo(dto.id, dto.type, eventAttributesMapper.map(dto.attributes))
    }
}