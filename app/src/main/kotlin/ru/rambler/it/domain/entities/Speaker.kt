package ru.rambler.it.domain.entities


data class Speaker(val id: Int,
                   val firstName: String?,
                   val lastName: String?,
                   val bio: String?,
                   val job: String?,
                   val company: String?,
                   val image: String?,
                   val socialProfiles: List<SocialProfile>) {
}