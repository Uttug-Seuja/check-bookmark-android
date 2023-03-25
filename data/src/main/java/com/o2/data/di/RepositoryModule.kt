package com.o2.data.di


import com.o2.data.api.MainAPIService
import com.o2.data.repository.MainRepositoryImpl
import com.o2.domain.repository.MainRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module
object RepositoryModule {
    @Provides
    @Singleton
    fun provideMainRepository(mainAPIService: MainAPIService): MainRepository {
        return MainRepositoryImpl(mainAPIService)
    }
}