package com.example.love_calculator_hw_5_2.room

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.love_calculator_hw_5_2.remote.LoveModel

@Database(entities = [LoveModel::class], version = 1)
abstract class AppDatabase :RoomDatabase() {
    abstract fun loveDao(): LoveDao
}