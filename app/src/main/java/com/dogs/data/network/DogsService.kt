package com.dogs.data.network

import com.dogs.core.RetrofitHelper
import com.dogs.data.model.Dogs
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject

class DogsService @Inject constructor(
    private val api:DogsApiClient
){

//    private val retrofit = RetrofitHelper.getRetrofit()

    suspend fun getAllDogs():Dogs?{
        return withContext(Dispatchers.IO){
            val response = api.getDogsByBreeds("hound/images")
            response.body()
        }
    }

    suspend fun getDogsByBreed(query: String):Dogs?{
        return withContext(Dispatchers.IO){
            val response = api.getDogsByBreeds("$query/images")
            response.body()
        }
    }

//    suspend fun getDogsByBreed(query: String):Dogs?{
//        return withContext(Dispatchers.IO){
//            val response = retrofit.create(DogsApiClient::class.java).getDogsByBreeds("$query/images")
//            response.body()
//        }
//    }
}