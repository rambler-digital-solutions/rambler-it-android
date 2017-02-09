package ru.rambler.it.domain.entities

import ru.rambler.it.data.dto.ParentBe

data class Tag(val id: Int, val name: String, val slug: String) : ParentBe {
}