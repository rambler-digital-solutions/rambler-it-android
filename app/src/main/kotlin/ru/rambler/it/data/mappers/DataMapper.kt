package ru.rambler.it.data.mappers

interface DataMapper<DTO, DBO> {
    fun map(dto: DTO): DBO
}