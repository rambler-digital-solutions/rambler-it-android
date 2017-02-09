package ru.rambler.it.data.dto

import com.google.gson.annotations.SerializedName
import ru.rambler.it.domain.entities.Brand
import java.util.*

data class EventAttributesDto(val name: String, val kind: String,
                              @SerializedName("starts_at") val startDate: Date,
                              @SerializedName("ends_at") val endDate: Date?,
                              @SerializedName("updated_at") val updateDate: Date?,
                              @SerializedName("deleted_at") val deleteDate: Date?,
                              val deleted: Boolean = false,
                              val brand: Brand,
                              val tech: TechDto,
                              val lectures: List<LectureDto>) : ParentDto {
}