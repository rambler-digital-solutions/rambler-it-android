package ru.rambler.it.domain.entities

import ru.rambler.it.data.dto.ParentBe

data class Tech(val id: Int, val name: String, val color: String) : ParentBe {
}