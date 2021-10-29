package com.dogs.data.model

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName

@Entity
data class Dogs(
//    @PrimaryKey(autoGenerate = true)
    @SerializedName("status") var status: String,
    @SerializedName("message") var  dogImages: List<String>
    )