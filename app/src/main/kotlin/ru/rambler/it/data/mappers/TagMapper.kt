package ru.rambler.it.data.mappers

import ru.rambler.it.data.dbo.TagDbo
import ru.rambler.it.data.dto.TagDto
import ru.rambler.it.domain.entities.Tag

class TagMapper : DataMapper<Tag, TagDto, TagDbo> {
    override fun mapToDbo(entity: Tag): TagDbo {
        return TagDbo(entity.id, entity.name, entity.slug)
    }

    override fun mapDto(dto: TagDto): Tag {
        return Tag(dto.id, dto.name, dto.slug)
    }

    override fun mapFromDbo(dbo: TagDbo): Tag {
        return Tag(dbo.id, dbo.name, dbo.slug)
    }
}