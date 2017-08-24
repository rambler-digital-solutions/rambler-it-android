package ru.rambler.it.model

import com.google.gson.annotations.SerializedName
import java.util.*

data class Attributes(
        var name: String,
        var kind: String,
        @SerializedName("starts_at")
        var startsAt: Date,
        @SerializedName("ends_at")
        var endsAt: Date,
        @SerializedName("updated_at")
        var updatedAt: Date,
        @SerializedName("deleted_at")
        var deletedAt: Date? = null,
        @SerializedName("deleted")
        var isDeleted: Boolean,
        var brand: Brand,
        var tech: Tech,
        var lectures: List<Lecture> = emptyList()
)
