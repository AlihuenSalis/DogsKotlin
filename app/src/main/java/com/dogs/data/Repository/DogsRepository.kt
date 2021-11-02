package com.dogs.data.Repository

import com.dogs.data.DogsProvider
import com.dogs.data.model.Dogs
import com.dogs.data.network.DogsService
import javax.inject.Inject

class DogsRepository @Inject constructor(
    private val api: DogsService,
    private val dogsProvider: DogsProvider
) {

    suspend fun getAllDogs(): Dogs? {
        val response = api.getAllDogs()
        dogsProvider.allDog = response // esto seria como guardarlo en la bd
        return response
    }

    suspend fun getDogsByBreeds(query: String): Dogs? {
        val response = api.getDogsByBreed(query)
        dogsProvider.breedList = response // esto seria como guardarlo en la bd
        return response
    }


}