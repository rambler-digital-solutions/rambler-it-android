package ru.rambler.it.model

import com.google.gson.annotations.SerializedName

data class Brand(
        val id: Long,
        val name: String,
        val description: String,
        @SerializedName("home_page")
        val homePage: String,
        val logo: String
)
