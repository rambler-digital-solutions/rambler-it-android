package ru.rambler.it.data.mappers

import ru.rambler.it.data.dbo.BrandDbo
import ru.rambler.it.data.dto.Brand

class BrandMapper : DataMapper<Brand, BrandDbo> {
    override fun map(dto: Brand): BrandDbo {
        return BrandDbo(dto.id, dto.name, dto.description, dto.homePage, dto.logo)
    }
}