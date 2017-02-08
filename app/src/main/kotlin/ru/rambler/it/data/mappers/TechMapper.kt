package ru.rambler.it.data.mappers

import ru.rambler.it.data.dbo.TechDbo
import ru.rambler.it.data.dto.Tech

class TechMapper : DataMapper<Tech, TechDbo> {
    override fun map(dto: Tech): TechDbo {
        return TechDbo(dto.id, dto.name, dto.color)
    }
}