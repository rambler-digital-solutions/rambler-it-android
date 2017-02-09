package ru.rambler.it.data.mappers

import ru.rambler.it.data.dbo.TechDbo
import ru.rambler.it.data.dto.TechDto
import ru.rambler.it.domain.entities.Tech

class TechMapper : DataMapper<Tech, TechDto, TechDbo> {
    override fun mapToDbo(entity: Tech): TechDbo {
        return TechDbo(entity.id, entity.name, entity.color)
    }

    override fun mapFromDbo(dbo: TechDbo): Tech {
        return Tech(dbo.id, dbo.name, dbo.color)
    }

    override fun mapDto(dto: TechDto): Tech {
        return Tech(dto.id, dto.name, dto.color)
    }
}