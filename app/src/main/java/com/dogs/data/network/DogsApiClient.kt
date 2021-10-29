package com.dogs.data.network

import com.dogs.data.model.Dogs
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Url

interface DogsApiClient {
    @GET()
    suspend fun getDogsByBreeds(@Url url: String):Response<Dogs>
}