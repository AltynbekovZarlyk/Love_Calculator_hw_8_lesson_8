package com.example.love_calculator_hw_5_2.room

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.example.love_calculator_hw_5_2.remote.LoveModel

@Dao
interface LoveDao{

    @Insert
    fun insertLove(loveModel: LoveModel)

    @Query("SELECT * FROM love_table")
    fun getAll(): List<LoveModel>

    @Query("SELECT * FROM love_table ORDER BY firstName ASC")
    fun getAllSort(): List<LoveModel>
}