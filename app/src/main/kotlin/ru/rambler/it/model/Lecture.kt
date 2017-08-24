package ru.rambler.it.model

data class Lecture(
        var id: Long,
        var title: String,
        var description: String,
        var tags: List<Tag> = emptyList(),
        var materials: List<Material> = emptyList(),
        var speaker: Speaker
)
