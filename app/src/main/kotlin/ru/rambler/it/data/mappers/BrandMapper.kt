package ru.rambler.it.data.mappers

import ru.rambler.it.data.dbo.BrandDbo
import ru.rambler.it.data.dto.BrandDto
import ru.rambler.it.domain.entities.Brand

class BrandMapper : DataMapper<Brand, BrandDto, BrandDbo> {
    override fun mapToDbo(entity: Brand): BrandDbo {
        return BrandDbo(entity.id, entity.name, entity.description, entity.homePage, entity.logo)
    }

    override fun mapDto(dto: BrandDto): Brand {
        return Brand(dto.id, dto.name, dto.description, dto.homePage, dto.logo)
    }

    override fun mapFromDbo(dbo: BrandDbo): Brand {
        return Brand(dbo.id, dbo.name, dbo.description, dbo.homePage, dbo.logo)
    }
}