package com.dogs.domain

import com.dogs.data.Repository.DogsRepository
import com.dogs.data.model.Dogs
import javax.inject.Inject

class GetDogsUC @Inject constructor(
    private val repository: DogsRepository
){

    //con esta funcion no hace falta hacer referencia a la clase. solo con nombrarla ya se llama este metodo
    suspend operator fun invoke():Dogs? = repository.getAllDogs()
}