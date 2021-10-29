package com.dogs.domain

import com.dogs.data.Repository.DogsRepository
import com.dogs.data.model.Dogs

class GetDogsByBreedUC {

    private val repository = DogsRepository()

    suspend operator fun invoke(query: String):Dogs? = repository.getDogsByBreeds(query)

}