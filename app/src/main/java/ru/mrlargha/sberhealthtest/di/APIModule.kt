package ru.mrlargha.sberhealthtest.di

import com.squareup.picasso.BuildConfig
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import ru.mrlargha.sberhealthtest.data.MedicineAPI

@Module
@InstallIn(SingletonComponent::class)
class APIModule {
    private val retrofit =
        Retrofit.Builder().addConverterFactory(GsonConverterFactory.create()).build()

    @Provides
    fun provideApi(): MedicineAPI {
        return retrofit.create(MedicineAPI::class.java)
    }
}