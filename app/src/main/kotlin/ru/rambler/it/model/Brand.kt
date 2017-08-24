package ru.rambler.it.model

import com.google.gson.annotations.SerializedName

data class Brand(
        var id: String,
        var name: String,
        var description: String,
        @SerializedName("home_page")
        var homePage: String,
        var logo: String
)
