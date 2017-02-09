package ru.rambler.it.domain.entities

import com.google.gson.annotations.SerializedName
import ru.rambler.it.data.dto.ParentBe

data class Speaker(val id: Int,
                   @SerializedName("first_name") val firstName: String,
                   @SerializedName("last_name") val lastName: String,
                   val bio: String,
                   val job: String,
                   val company: String,
                   val image: String?,
                   @SerializedName("social_profiles") val socialProfiles: List<SocialProfile>) : ParentBe {
}