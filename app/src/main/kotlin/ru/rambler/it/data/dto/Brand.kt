package ru.rambler.it.data.dto

import com.google.gson.annotations.SerializedName

data class Brand(val id: Int, val name: String, val description: String,
                 @SerializedName("home_page") val homePage: String,
                 val logo: String) : ParentDto {
}