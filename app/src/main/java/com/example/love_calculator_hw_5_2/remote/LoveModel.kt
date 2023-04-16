package com.example.love_calculator_hw_5_2.remote

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName

@Entity(tableName = "love_table")
data class LoveModel(
    @PrimaryKey(autoGenerate = true)
    var id: Int,
    @SerializedName("fname")
    var firstName: String,
    @SerializedName("sname")
    var secondName: String,
    var percentage: String,
    var result: String,
) : java.io.Serializable