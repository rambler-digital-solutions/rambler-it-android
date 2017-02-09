package ru.rambler.it.data.mappers

import ru.rambler.it.data.dbo.SocialProfileDbo
import ru.rambler.it.domain.entities.SocialProfile

class SocialProfileMapper : DataMapper<SocialProfile, SocialProfileDbo>{
    override fun map(dto: SocialProfile): SocialProfileDbo {
        return SocialProfileDbo(dto.network, dto.link)
    }
}