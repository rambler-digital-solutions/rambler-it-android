package ru.rambler.it.model

import com.google.gson.annotations.SerializedName

data class Material(
        val id: Long,
        val title: String,
        val link: String,
        val kind: String,
        @SerializedName("youtube_code")
        val youtubeCode: String
)