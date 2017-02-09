package ru.rambler.it.domain.entities

import ru.rambler.it.data.dto.ParentBe

data class SocialProfile(val network: String, val link: String) : ParentBe {
}