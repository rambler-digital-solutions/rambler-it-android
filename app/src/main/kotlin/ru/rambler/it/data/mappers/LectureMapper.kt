package ru.rambler.it.data.mappers

import io.realm.RealmList
import ru.rambler.it.data.dbo.LectureDbo
import ru.rambler.it.data.dbo.MaterialDbo
import ru.rambler.it.data.dbo.TagDbo
import ru.rambler.it.data.dto.Lecture


class LectureMapper : DataMapper<Lecture, LectureDbo> {

    private val tagMapper = TagMapper()
    private val materialMapper = MaterialMapper()
    private val speakerMapper = SpeakerMapper()

    override fun map(dto: Lecture): LectureDbo {
        val tagList = RealmList<TagDbo>()
        dto.tags.mapTo(tagList) { tagMapper.map(it) }

        val materialList = RealmList<MaterialDbo>()
        dto.materials.mapTo(materialList) { materialMapper.map(it) }

        return LectureDbo(dto.id, dto.title, dto.description, tagList, materialList, speakerMapper.map(dto.speaker))
    }
}