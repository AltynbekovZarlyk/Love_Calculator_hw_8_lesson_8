package com.example.love_calculator_hw_5_2

import android.content.Context
import com.example.love_calculator_hw_5_2.data.Pref
import com.example.love_calculator_hw_5_2.remote.LoveApi
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class AppModule {

    @Provides
    fun provideApi(): LoveApi {
        return Retrofit.Builder().baseUrl("https://love-calculator.p.rapidapi.com/")
            .addConverterFactory(
                GsonConverterFactory.create()
            ).build().create(LoveApi::class.java)
    }

    @Provides
    @Singleton
    fun providePreference(@ApplicationContext context: Context): Pref {
        return Pref((context))
    }

}