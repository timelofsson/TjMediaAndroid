package com.example.myapp.models

import android.os.Parcel
import android.os.Parcelable


data class PoseWithMultiplePictures(var title: String, var message: String, var image: Int, var imageHighRes : IntArray?) : Parcelable {
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

    companion object CREATOR : Parcelable.Creator<PoseWithMultiplePictures> {
        override fun createFromParcel(parcel: Parcel): PoseWithMultiplePictures {
            return PoseWithMultiplePictures(parcel)
        }

        override fun newArray(size: Int): Array<PoseWithMultiplePictures?> {
            return arrayOfNulls(size)
        }
    }
}

