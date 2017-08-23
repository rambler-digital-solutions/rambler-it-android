package ru.rambler.it.model

import com.google.gson.annotations.Expose
import java.util.*

data class GetEventsResponse(
        @Expose
        var data: List<Datum> = ArrayList()
)
