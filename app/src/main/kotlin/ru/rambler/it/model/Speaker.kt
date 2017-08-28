package ru.rambler.it.model

import com.google.gson.annotations.SerializedName

data class Speaker(
        val id: Long,
        @SerializedName("first_name")
        val firstName: String,
        @SerializedName("last_name")
        val lastName: String,
        val bio: String,
        val job: String,
        val company: String,
        val image: String,
        @SerializedName("social_profiles")
        val socialProfiles: List<SocialProfile> = emptyList()
)
