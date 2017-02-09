package ru.rambler.it.data.dto

data class LectureDto(val id: Int, val title: String?, val description: String?, val tags: List<TagDto>?,
                      val materials: List<MaterialDto>?, val speaker: SpeakerDto?) {
}