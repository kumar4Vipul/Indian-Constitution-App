package com.appbusters.robinpc.constitutionofindia.data.model

import com.google.gson.annotations.SerializedName

data class ReadElement(
        @SerializedName("read_element_id")
        val id: Int,
        @SerializedName("category")
        val categoryName: String,
        @SerializedName("content")
        val content: String,
        @SerializedName("tags")
        val tags: List<String>,
        @SerializedName("title")
        val title: String
)