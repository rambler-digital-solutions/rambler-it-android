package ru.rambler.it.data.mappers

import ru.rambler.it.data.dbo.MaterialDbo
import ru.rambler.it.data.dto.Material


class MaterialMapper : DataMapper<Material, MaterialDbo> {
    override fun map(dto: Material): MaterialDbo {
        return MaterialDbo(dto.id, dto.title, dto.link, dto.kind)
    }
}