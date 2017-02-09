package ru.rambler.it.data.mappers

import ru.rambler.it.data.dbo.SpeakerDbo
import ru.rambler.it.domain.entities.Speaker


class SpeakerMapper : DataMapper<Speaker, SpeakerDbo>{
    override fun map(dto: Speaker): SpeakerDbo {
        return SpeakerDbo(dto.id, dto.firstName, dto.lastName, dto.bio, dto.job, dto.company, dto.image)
    }
}