package com.example.pokedex.di

import com.example.pokedex.data.sources.remote.api.ApiService
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.scalars.ScalarsConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class InstanceProvider {

    @Singleton
    @Provides
    fun provideApiService(): ApiService {
        val retrofit = Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(ScalarsConverterFactory.create())
            .build()

        return retrofit.create(ApiService::class.java)
    }


    companion object {
        private const val BASE_URL = "https://pokeapi.co/api/v2/"
    }

}