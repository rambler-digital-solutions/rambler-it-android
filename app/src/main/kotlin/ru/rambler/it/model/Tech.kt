package ru.rambler.it.model

import com.google.gson.annotations.Expose

data class Tech(
        @Expose
        var id: String? = null,
        @Expose
        var name: String? = null,
        @Expose
        var color: String? = null
)
