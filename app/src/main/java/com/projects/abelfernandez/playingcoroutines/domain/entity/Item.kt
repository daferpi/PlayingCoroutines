package com.projects.abelfernandez.playingcoroutines.domain.entity

import android.os.Parcel
import android.os.Parcelable

data class Item(val id: Int?,
                val name: String?,
                val full_name: String?,
                val owner: ItemOwner?,
                val private: Boolean,
                val url: String?,
                val description: String?): Parcelable {
    constructor(parcel: Parcel) : this(
            parcel.readValue(Int::class.java.classLoader) as? Int,
            parcel.readString(),
            parcel.readString(),
            parcel.readParcelable(Item::class.java.classLoader),
            parcel.readByte() != 0.toByte(),
            parcel.readString(),
            parcel.readString())

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeValue(id)
        parcel.writeString(name)
        parcel.writeString(full_name)
        parcel.writeParcelable(owner, flags)
        parcel.writeByte(if (private) 1 else 0)
        parcel.writeString(url)
        parcel.writeString(description)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<Item> {
        override fun createFromParcel(parcel: Parcel): Item {
            return Item(parcel)
        }

        override fun newArray(size: Int): Array<Item?> {
            return arrayOfNulls(size)
        }
    }

}


data class ItemOwner(
        val login: String?,
        val id: Int?,
        val avatar_url: String?,
        val url: String?) : Parcelable {
    constructor(parcel: Parcel) : this(
            parcel.readString(),
            parcel.readValue(Int::class.java.classLoader) as? Int,
            parcel.readString(),
            parcel.readString())

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeString(login)
        parcel.writeValue(id)
        parcel.writeString(avatar_url)
        parcel.writeString(url)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<ItemOwner> {
        override fun createFromParcel(parcel: Parcel): ItemOwner {
            return ItemOwner(parcel)
        }

        override fun newArray(size: Int): Array<ItemOwner?> {
            return arrayOfNulls(size)
        }
    }
}