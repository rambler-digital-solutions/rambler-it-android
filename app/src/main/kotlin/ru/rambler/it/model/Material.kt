package ru.rambler.it.model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class Material(
        @Expose
        var id: String? = null,
        @Expose
        var title: String? = null,
        @Expose
        var link: String? = null,
        @Expose
        var kind: String? = null,
        @SerializedName("youtube_code")
        @Expose
        var youtubeCode: String? = null
)