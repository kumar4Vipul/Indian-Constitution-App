package com.appbusters.robinpc.constitutionofindia.data.model

import android.os.Parcel
import android.os.Parcelable
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName

@Entity(tableName = "read_element")
class ReadElement(@PrimaryKey @SerializedName("read_element_id") val id: Int,
                  @ColumnInfo(name = "title") @SerializedName("title") val title: String?,
                  @ColumnInfo(name = "subtitle") @SerializedName("subtitle") val subtitle: String?,
                  @ColumnInfo(name = "category") @SerializedName("category") val categoryName: String?,
                  @ColumnInfo(name = "short_description") @SerializedName("short_description") val shortDescription: String?,
                  @ColumnInfo(name = "content") @SerializedName("content") val content: String?,
                  @ColumnInfo(name = "tags") @SerializedName("tags") val tags: List<String>?,
                  @ColumnInfo(name = "is_saved") val isSaved: Int = 0): Parcelable {

        constructor(parcel: Parcel) : this(
                parcel.readInt(),
                parcel.readString(),
                parcel.readString(),
                parcel.readString(),
                parcel.readString(),
                parcel.readString(),
                parcel.createStringArrayList(),
                parcel.readInt()) {
        }

        override fun writeToParcel(parcel: Parcel, flags: Int) {
                parcel.writeInt(id)
                parcel.writeString(title)
                parcel.writeString(subtitle)
                parcel.writeString(categoryName)
                parcel.writeString(shortDescription)
                parcel.writeString(content)
                parcel.writeStringList(tags)
                parcel.writeInt(isSaved)
        }

        override fun describeContents(): Int {
                return 0
        }

        companion object CREATOR : Parcelable.Creator<ReadElement> {
                override fun createFromParcel(parcel: Parcel): ReadElement {
                        return ReadElement(parcel)
                }

                override fun newArray(size: Int): Array<ReadElement?> {
                        return arrayOfNulls(size)
                }
        }
}