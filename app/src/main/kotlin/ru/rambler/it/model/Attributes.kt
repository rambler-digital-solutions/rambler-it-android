package ru.rambler.it.model

import com.google.gson.annotations.SerializedName

data class Attributes(
        var name: String,
        var kind: String,
        @SerializedName("starts_at")
        var startsAt: String,
        @SerializedName("ends_at")
        var endsAt: String,
        @SerializedName("updated_at")
        var updatedAt: String,
        @SerializedName("deleted_at")
        var deletedAt: String,
        @SerializedName("deleted")
        var isDeleted: Boolean,
        var brand: Brand,
        var tech: Tech,
        var lectures: List<Lecture> = emptyList()
)
