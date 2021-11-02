package com.dogs.di

import com.dogs.data.network.DogsApiClient
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

//Este objeto me provee dependencias que no sean faciles de proveer como las anteriores.
@Module // los modulos proveen dependencias
@InstallIn(SingletonComponent::class) // Este es el alcance
object NetworkModule {

    @Singleton // patron de diseño singleton
    @Provides
    fun provideRetrofit(): Retrofit{
        return Retrofit.Builder()
            .baseUrl("https://dog.ceo/api/breed/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    @Singleton // patron de diseño singleton
    @Provides
    fun provideQuoteApiClient(retrofit: Retrofit): DogsApiClient{
        return retrofit.create(DogsApiClient::class.java)
    }
}