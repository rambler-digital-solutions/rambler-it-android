package ru.rambler.it.model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName
import java.util.*

data class Attributes(
        @Expose
        var name: String? = null,
        @Expose
        var kind: String? = null,
        @SerializedName("starts_at")
        @Expose
        var startsAt: String? = null,
        @SerializedName("ends_at")
        @Expose
        var endsAt: String? = null,
        @SerializedName("updated_at")
        @Expose
        var updatedAt: String? = null,
        @SerializedName("deleted_at")
        @Expose
        var deletedAt: String? = null,
        @SerializedName("deleted")
        @Expose
        var isDeleted: Boolean = false,
        @Expose
        var brand: Brand? = null,
        @Expose
        var tech: Tech? = null,
        @Expose
        var lectures: List<Lecture> = ArrayList()
)
