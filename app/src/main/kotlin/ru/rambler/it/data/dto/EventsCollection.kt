package ru.rambler.it.data.dto

import ru.rambler.it.domain.entities.Event

data class EventsCollection(val data: List<Event>) : ParentDto {
}