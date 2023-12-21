package com.example.pokedex.di

import com.example.pokedex.domain.repositories.IPokemonRepository
import com.example.pokedex.data.repositories.PokemonAPIRepositoryImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent


@Module
@InstallIn(ViewModelComponent::class)
abstract class PokemonRepositoryModule {

    @Binds
    abstract fun bindRepository(
        pokemonAPIRepositoryImpl: PokemonAPIRepositoryImpl
    ): IPokemonRepository
}