package ru.rambler.it.data.mappers

import io.realm.RealmList
import ru.rambler.it.data.dbo.LectureDbo
import ru.rambler.it.data.dbo.MaterialDbo
import ru.rambler.it.data.dbo.TagDbo
import ru.rambler.it.data.dto.LectureDto
import ru.rambler.it.domain.entities.Lecture
import ru.rambler.it.domain.entities.Material
import ru.rambler.it.domain.entities.Tag
import java.util.*


class LectureMapper : DataMapper<Lecture, LectureDto, LectureDbo> {

    private val tagMapper = TagMapper()
    private val materialMapper = MaterialMapper()
    private val speakerMapper = SpeakerMapper()

    override fun mapToDbo(entity: Lecture): LectureDbo {
        val tagList = RealmList<TagDbo>()
        entity.tags?.mapTo(tagList) { tagMapper.mapToDbo(it) }

        val materialList = RealmList<MaterialDbo>()
        entity.materials?.mapTo(materialList) { materialMapper.mapToDbo(it) }

        return LectureDbo(entity.id, entity.title, entity.description, tagList, materialList, entity.speaker?.let { speakerMapper.mapToDbo(it) })
    }

    override fun mapDto(dto: LectureDto): Lecture {
        val tagList = ArrayList<Tag>()
        dto.tags?.mapTo(tagList) { tagMapper.mapDto(it) }

        val materialList = ArrayList<Material>()
        dto.materials?.mapTo(materialList) { materialMapper.mapDto(it) }

        return Lecture(dto.id, dto.title, dto.description, tagList, materialList, dto.speaker?.let { speakerMapper.mapDto(it) })
    }

    override fun mapFromDbo(dbo: LectureDbo): Lecture {
        val tagList = ArrayList<Tag>()
        dbo.tags?.mapTo(tagList) { tagMapper.mapFromDbo(it) }

        val materialList = ArrayList<Material>()
        dbo.materials?.mapTo(materialList) { materialMapper.mapFromDbo(it) }

        return Lecture(dbo.id, dbo.title, dbo.description, tagList, materialList, dbo.speaker?.let { speakerMapper.mapFromDbo(it) })
    }
}