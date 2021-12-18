package ru.mrlargha.sberhealthtest.di

import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import ru.mrlargha.sberhealthtest.data.NetworkMedicineRepository
import ru.mrlargha.sberhealthtest.domain.repository.IMedicineRepository

@Module
@InstallIn(SingletonComponent::class)
interface RepositoryModule {
    @Binds
    fun bindMedicineRepository(repository: NetworkMedicineRepository): IMedicineRepository
}