package ru.rambler.it.domain.entities

import ru.rambler.it.data.dto.ParentBe

data class Material(val id: Int, val title: String, val link: String, val kind: String) : ParentBe {
}