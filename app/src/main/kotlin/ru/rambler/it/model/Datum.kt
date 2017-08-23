package ru.rambler.it.model

import com.google.gson.annotations.Expose

data class Datum(
        @Expose
        var type: String? = null,
        @Expose
        var id: String? = null,
        @Expose
        var attributes: Attributes? = null
)
