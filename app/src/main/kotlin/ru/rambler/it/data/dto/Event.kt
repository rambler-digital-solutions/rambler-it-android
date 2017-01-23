package ru.rambler.it.data.dto

data class Event(val id: Int, val type: String, val attributes: EventAttributes) : ParentDto {
}