package com.dogs.domain

import com.dogs.data.Repository.DogsRepository
import com.dogs.data.model.Dogs
import javax.inject.Inject

class GetDogsByBreedUC @Inject constructor(
    private val repository: DogsRepository
){

    suspend operator fun invoke(query: String):Dogs? = repository.getDogsByBreeds(query)

}