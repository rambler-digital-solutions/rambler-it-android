package ru.rambler.it.model

import com.google.gson.annotations.SerializedName

data class Speaker(
        var id: String,
        @SerializedName("first_name")
        var firstName: String,
        @SerializedName("last_name")
        var lastName: String,
        var bio: String,
        var job: String,
        var company: String,
        var image: String,
        @SerializedName("social_profiles")
        var socialProfiles: List<SocialProfile> = emptyList()
)
