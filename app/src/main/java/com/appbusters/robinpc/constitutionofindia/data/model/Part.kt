package com.appbusters.robinpc.constitutionofindia.data.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName

@Entity(tableName = "part")
data class Part(

        @PrimaryKey
        @SerializedName("title")
        val title: String,

        @ColumnInfo(name = "subtitle")
        @SerializedName("subtitle")
        val subtitle: String,

        @ColumnInfo(name = "short_description")
        @SerializedName("short_description")
        val shortDescription: String,

        @ColumnInfo(name = "start_index")
        @SerializedName("start_index")
        val startIndex: Int,

        @ColumnInfo(name = "end_index")
        @SerializedName("end_index")
        val endIndex: Int
)