package ru.rambler.it.domain.entities

import com.google.gson.annotations.SerializedName
import ru.rambler.it.data.dto.ParentDto

data class Brand(val id: Int, val name: String, val description: String,
                 @SerializedName("home_page") val homePage: String,
                 val logo: String) : ParentDto {
}