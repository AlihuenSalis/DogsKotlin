package com.dogs.data.Repository

import com.dogs.data.DogsProvider
import com.dogs.data.model.Dogs
import com.dogs.data.network.DogsService

class DogsRepository {

    private val api = DogsService()

    suspend fun getAllDogs(): Dogs? {
        val response = api.getAllDogs()
        DogsProvider.allDog = response // esto seria como guardarlo en la bd
        return response
    }

    suspend fun getDogsByBreeds(query: String): Dogs? {
        val response = api.getDogsByBreed(query)
        DogsProvider.breedList = response // esto seria como guardarlo en la bd
        return response
    }


}