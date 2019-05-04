package com.appbusters.robinpc.constitutionofindia.data.model

import android.os.Parcel
import android.os.Parcelable
import com.google.gson.annotations.SerializedName

class ReadElement(@SerializedName("read_element_id") val id: Int,
                  @SerializedName("title") val title: String?,
                  @SerializedName("subtitle") val subtitle: String?,
                  @SerializedName("category") val categoryName: String?,
                  @SerializedName("short_description") val shortDescription: String?,
                  @SerializedName("content") val content: String?,
                  @SerializedName("tags") val tags: List<String>?): Parcelable {

        constructor(parcel: Parcel) : this(
                parcel.readInt(),
                parcel.readString(),
                parcel.readString(),
                parcel.readString(),
                parcel.readString(),
                parcel.readString(),
                parcel.createStringArrayList()) {
        }

        override fun writeToParcel(parcel: Parcel, flags: Int) {
                parcel.writeInt(id)
                parcel.writeString(title)
                parcel.writeString(subtitle)
                parcel.writeString(categoryName)
                parcel.writeString(shortDescription)
                parcel.writeString(content)
                parcel.writeStringList(tags)
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