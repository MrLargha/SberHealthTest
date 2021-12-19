package ru.mrlargha.sberhealthtest.di

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import ru.mrlargha.sberhealthtest.BuildConfig
import ru.mrlargha.sberhealthtest.data.MedicineAPI

@Module
@InstallIn(SingletonComponent::class)
class APIModule {
    private val retrofit =
        Retrofit.Builder().baseUrl(BuildConfig.API_URL).addConverterFactory(GsonConverterFactory.create()).build()

    @Provides
    fun provideApi(): MedicineAPI {
        return retrofit.create(MedicineAPI::class.java)
    }
}