package ru.rambler.it.model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class Brand(
        @Expose
        var id: String? = null,
        @Expose
        var name: String? = null,
        @Expose
        var description: String? = null,
        @SerializedName("home_page")
        @Expose
        var homePage: String? = null,
        @Expose
        var logo: String? = null
)
