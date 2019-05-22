package com.appbusters.robinpc.constitutionofindia.data.model

import com.google.gson.annotations.SerializedName

data class Tag(
        @SerializedName("title") val title: String,
        @SerializedName("elaborate_title") val elaborateTitle: String,
        @SerializedName("search_term") val searchTerm: String,
        @SerializedName("category") val categoryName: String?,
        @SerializedName("read_element_ids") val readElementIds: List<Int>
)
