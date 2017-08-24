package ru.rambler.it.model

import com.google.gson.annotations.SerializedName

data class Material(
        var id: Long,
        var title: String,
        var link: String,
        var kind: String,
        @SerializedName("youtube_code")
        var youtubeCode: String
)