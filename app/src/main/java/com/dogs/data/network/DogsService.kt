package com.dogs.data.network

import com.dogs.core.RetrofitHelper
import com.dogs.data.model.Dogs
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class DogsService {

    private val retrofit = RetrofitHelper.getRetrofit()

    suspend fun getAllDogs():Dogs?{
        return withContext(Dispatchers.IO){
            val response = retrofit.create(DogsApiClient::class.java).getDogsByBreeds("hound/images")
            response.body()
        }
    }

    suspend fun getDogsByBreed(query: String):Dogs?{
        return withContext(Dispatchers.IO){
            val response = retrofit.create(DogsApiClient::class.java).getDogsByBreeds("$query/images")
            response.body()
        }
    }
}