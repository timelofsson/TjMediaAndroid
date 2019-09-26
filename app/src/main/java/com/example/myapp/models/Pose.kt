package com.example.myapp.models

import android.os.Parcel
import android.os.Parcelable


data class Pose(var title: String, var message: String, var image: Int, var imageHighRes : IntArray?) : Parcelable {
    constructor(parcel: Parcel) : this(
        parcel.readString().toString(),
        parcel.readString().toString(),
        parcel.readInt(),
        parcel.createIntArray()
    )

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeString(title)
        parcel.writeString(message)
        parcel.writeInt(image)
        parcel.writeIntArray(imageHighRes)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<Pose> {
        override fun createFromParcel(parcel: Parcel): Pose {
            return Pose(parcel)
        }

        override fun newArray(size: Int): Array<Pose?> {
            return arrayOfNulls(size)
        }
    }
}

