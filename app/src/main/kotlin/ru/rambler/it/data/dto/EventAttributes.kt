package ru.rambler.it.data.dto

import com.google.gson.annotations.SerializedName
import java.util.*

data class EventAttributes(val name: String, val kind: String,
                           @SerializedName("starts_at") val startDate: Date,
                           @SerializedName("ends_at") val endDate: Date?,
                           @SerializedName("updated_at") val updateDate: Date?,
                           @SerializedName("deleted_at") val deleteDate: Date?,
                           val deleted: Boolean = false,
                           val brand: Brand,
                           val tech: Tech,
                           val lectures: List<Lecture>) : ParentDto {
}