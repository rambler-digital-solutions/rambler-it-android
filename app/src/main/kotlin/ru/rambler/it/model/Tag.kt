package ru.rambler.it.model

import com.google.gson.annotations.Expose

data class Tag(
        @Expose
        var id: String? = null,
        @Expose
        var name: String? = null,
        @Expose
        var slug: String? = null
)