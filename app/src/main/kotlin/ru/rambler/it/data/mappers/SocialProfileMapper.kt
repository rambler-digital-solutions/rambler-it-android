package ru.rambler.it.data.mappers

import ru.rambler.it.data.dbo.SocialProfileDbo
import ru.rambler.it.data.dto.SocialProfileDto
import ru.rambler.it.domain.entities.SocialProfile

class SocialProfileMapper : DataMapper<SocialProfile, SocialProfileDto, SocialProfileDbo>{
    override fun mapToDbo(entity: SocialProfile): SocialProfileDbo {
        return SocialProfileDbo(entity.network, entity.link)

    }

    override fun mapDto(dto: SocialProfileDto): SocialProfile {
        return SocialProfile(dto.network, dto.link)
    }

    override fun mapFromDbo(dbo: SocialProfileDbo): SocialProfile {
        return SocialProfile(dbo.network, dbo.link)
    }
}