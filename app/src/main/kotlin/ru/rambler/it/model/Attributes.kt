package ru.rambler.it.model

import com.google.gson.annotations.SerializedName
import java.util.*

data class Attributes(
        val name: String,
        val kind: String,
        @SerializedName("starts_at")
        val startsAt: Date,
        @SerializedName("ends_at")
        val endsAt: Date,
        @SerializedName("updated_at")
        val updatedAt: Date,
        @SerializedName("deleted_at")
        val deletedAt: Date? = null,
        @SerializedName("deleted")
        val isDeleted: Boolean,
        val brand: Brand,
        val tech: Tech,
        val lectures: List<Lecture> = emptyList()
)
