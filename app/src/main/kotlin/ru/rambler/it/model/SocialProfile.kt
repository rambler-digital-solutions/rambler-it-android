package ru.rambler.it.model

import com.google.gson.annotations.Expose

data class SocialProfile(
        @Expose
        var network: String? = null,
        @Expose
        var link: String? = null
)