package com.appbusters.robinpc.constitutionofindia.data.model

data class ReadElement(
        val id: Int,
        val title: String,
        val content: String,
        val category: Category,
        val tags: List<String>,
        val isSaved: Boolean
)