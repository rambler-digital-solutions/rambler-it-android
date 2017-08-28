package ru.rambler.it.model

data class Lecture(
        val id: Long,
        val title: String,
        val description: String,
        val tags: List<Tag> = emptyList(),
        val materials: List<Material> = emptyList(),
        val speaker: Speaker
)
