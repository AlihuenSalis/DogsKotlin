package com.dogs.data

import com.dogs.data.model.Dogs

class DogsProvider {
    companion object {
        var allDog:Dogs? = Dogs("", emptyList())

        var breedList:Dogs? = Dogs("", emptyList())
    }
}