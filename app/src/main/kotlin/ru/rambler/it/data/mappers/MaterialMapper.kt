package ru.rambler.it.data.mappers

import ru.rambler.it.data.dbo.MaterialDbo
import ru.rambler.it.data.dto.MaterialDto
import ru.rambler.it.domain.entities.Material


class MaterialMapper : DataMapper<Material, MaterialDto, MaterialDbo> {
    override fun mapToDbo(entity: Material): MaterialDbo {
        return MaterialDbo(entity.id, entity.title, entity.link, entity.kind)
    }

    override fun mapDto(dto: MaterialDto): Material {
        return Material(dto.id, dto.title, dto.link, dto.kind)
    }

    override fun mapFromDbo(dbo: MaterialDbo): Material {
        return Material(dbo.id, dbo.title, dbo.link, dbo.kind)
    }
}