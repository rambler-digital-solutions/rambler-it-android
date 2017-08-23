package ru.rambler.it.model

import com.google.gson.annotations.Expose
import java.util.*

data class Lecture(
        @Expose
        var id: String? = null,
        @Expose
        var title: String? = null,
        @Expose
        var description: String? = null,
        @Expose
        var tags: List<Tag> = ArrayList(),
        @Expose
        var materials: List<Material> = ArrayList(),
        @Expose
        var speaker: Speaker? = null
)
