package com.appbusters.robinpc.constitutionofindia.data.model

import com.google.gson.annotations.SerializedName

data class Part(
        @SerializedName("title")
        val title: String,
        @SerializedName("subtitle")
        val subtitle: String,
        @SerializedName("short_description")
        val shortDescription: String,
        @SerializedName("start_index")
        val startIndex: Int,
        @SerializedName("end_index")
        val endIndex: Int
)