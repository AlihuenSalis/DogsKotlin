package com.dogs.data

import com.dogs.data.model.Dogs
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class DogsProvider @Inject constructor() {

        var allDog:Dogs? = Dogs("", emptyList())

        var breedList:Dogs? = Dogs("", emptyList())
}