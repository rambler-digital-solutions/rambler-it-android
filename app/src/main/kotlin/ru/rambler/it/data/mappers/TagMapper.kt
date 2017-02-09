package ru.rambler.it.data.mappers

import ru.rambler.it.data.dbo.TagDbo
import ru.rambler.it.domain.entities.Tag

class TagMapper : DataMapper<Tag, TagDbo> {
    override fun map(dto: Tag): TagDbo {
        return TagDbo(dto.id, dto.name, dto.slug)
    }
}