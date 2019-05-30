package com.appbusters.robinpc.constitutionofindia.data.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

import com.google.gson.annotations.SerializedName

@Entity(tableName = "book_links")
data class BookLink(
        @PrimaryKey @SerializedName("day_number") val id: Int,
        @ColumnInfo(name = "book_title") @SerializedName("book_title") val bookTitle: String,
        @ColumnInfo(name = "author_name") @SerializedName("author_name") val authorName: String,
        @ColumnInfo(name = "short_description") @SerializedName("short_description") val shortDescription: String,
        @ColumnInfo(name = "accent_color") @SerializedName("accent_color") val accentColor: String,
        @ColumnInfo(name = "cover_url") @SerializedName("cover_url") val coverUrl: String,
        @ColumnInfo(name = "affiliate_link") @SerializedName("affiliate_link") val affiliateLink: String
)
