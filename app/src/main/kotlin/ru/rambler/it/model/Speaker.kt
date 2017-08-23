package ru.rambler.it.model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName
import java.util.*

data class Speaker(
        @Expose
        var id: String? = null,
        @SerializedName("first_name")
        @Expose
        var firstName: String? = null,
        @SerializedName("last_name")
        @Expose
        var lastName: String? = null,
        @Expose
        var bio: String? = null,
        @Expose
        var job: String? = null,
        @Expose
        var company: String? = null,
        @Expose
        var image: String? = null,
        @SerializedName("social_profiles")
        @Expose
        var socialProfiles: List<Any> = ArrayList()
)
