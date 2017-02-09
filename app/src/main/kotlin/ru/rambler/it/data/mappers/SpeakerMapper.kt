package ru.rambler.it.data.mappers

import io.realm.RealmList
import ru.rambler.it.data.dbo.SocialProfileDbo
import ru.rambler.it.data.dbo.SpeakerDbo
import ru.rambler.it.data.dto.SpeakerDto
import ru.rambler.it.domain.entities.SocialProfile
import ru.rambler.it.domain.entities.Speaker
import java.util.*


class SpeakerMapper : DataMapper<Speaker, SpeakerDto, SpeakerDbo>{

    private val socialProfileMapper = SocialProfileMapper()

    override fun mapToDbo(entity: Speaker): SpeakerDbo {
        val socialProfileList = RealmList<SocialProfileDbo>()
        entity.socialProfiles?.mapTo(socialProfileList){socialProfileMapper.mapToDbo(it)}
        return SpeakerDbo(entity.id, entity.firstName, entity.lastName, entity.bio, entity.job, entity.company, entity.image, socialProfileList)
    }

    override fun mapDto(dto: SpeakerDto): Speaker {
        val socialProfileList = ArrayList<SocialProfile>()
        dto.socialProfiles?.mapTo(socialProfileList){socialProfileMapper.mapDto(it)}
        return Speaker(dto.id, dto.firstName, dto.lastName, dto.bio, dto.job, dto.company, dto.image, socialProfileList)
    }

    override fun mapFromDbo(dbo: SpeakerDbo): Speaker {
        val socialProfileList = ArrayList<SocialProfile>()
        dbo.socialProfiles?.mapTo(socialProfileList){socialProfileMapper.mapFromDbo(it)}
        return Speaker(dbo.id, dbo.firstName, dbo.lastName, dbo.bio, dbo.job, dbo.company, dbo.image, socialProfileList)
    }
}