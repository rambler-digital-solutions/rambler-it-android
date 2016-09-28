package ru.rambler.it.data.dto

data class Lecture(val id: Int, val title: String, val description: String, val tags: List<Tag>,
                   val materials: List<Material>, val speaker: Speaker) {
}