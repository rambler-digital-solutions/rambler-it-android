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
        var tags: List<Any> = ArrayList(),
        @Expose
        var materials: List<Any> = ArrayList(),
        @Expose
        var speaker: Speaker? = null
)
