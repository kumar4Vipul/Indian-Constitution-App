package com.appbusters.robinpc.constitutionofindia.data.model

import android.os.Parcel
import android.os.Parcelable
import com.google.gson.annotations.SerializedName

class Tag(@SerializedName("title") val title: String?,
          @SerializedName("elaborate_title") val elaborateTitle: String?,
          @SerializedName("search_term") val searchTerm: String?,
          @SerializedName("category") val categoryName: String?,
          @SerializedName("read_element_ids") val readElementIds: List<Int>): Parcelable {

    constructor(parcel: Parcel) : this(
            parcel.readString(),
            parcel.readString(),
            parcel.readString(),
            parcel.readString(),
            arrayListOf<Int>().apply {
                parcel.readList(this, Int::class.java.classLoader)
            })

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeString(title)
        parcel.writeString(elaborateTitle)
        parcel.writeString(searchTerm)
        parcel.writeString(categoryName)
        parcel.writeList(readElementIds)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<Tag> {
        override fun createFromParcel(parcel: Parcel): Tag {
            return Tag(parcel)
        }

        override fun newArray(size: Int): Array<Tag?> {
            return arrayOfNulls(size)
        }
    }
}
