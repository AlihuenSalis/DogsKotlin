package com.dogs.data.Database

import androidx.room.Dao
import androidx.room.Query
import com.dogs.data.model.Dogs

@Dao
interface DogDao {

//    @Query("SELECT * FROM Dogs")
//    fun getAllDogs() : Dogs
//
//    @Query("SELECT * FROM Dogs WHERE id = :id")
//    fun getDogsByBreed(id: Int) : Dogs
}