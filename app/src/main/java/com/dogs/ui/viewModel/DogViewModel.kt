package com.dogs.ui.viewModel

import android.widget.Toast
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.dogs.data.model.Dogs
import com.dogs.domain.GetDogsByBreedUC
import com.dogs.domain.GetDogsUC
import com.dogs.ui.view.MainActivity
import kotlinx.coroutines.launch

class DogViewModel : ViewModel() {

    // esto pone los dogs en la interfaz de usuario
    val isLoading = MutableLiveData<Boolean>()
    val rvVisibility = MutableLiveData<Boolean>()
    val dogsModel = MutableLiveData<Dogs>()
    val messageList = MutableLiveData<Dogs?>()

    var getDogsUseCase = GetDogsUC()
    var getDogsByBreedUC = GetDogsByBreedUC()

    fun onCreate() {
        // crea una corrutina que se maneja automaticamente
        viewModelScope.launch {
            isLoading.postValue(true)
            val result = getDogsUseCase()
            if (result != null) {
                if (!result.dogImages.isNullOrEmpty()) {
                    dogsModel.postValue(result!!)
                    isLoading.postValue(false)
                }
            } else {
                isLoading.postValue(false)
            }
        }
    }

    fun getBreeds(query: String){
        rvVisibility.postValue(false)
        isLoading.postValue(true)
        viewModelScope.launch {
            val filteredDog = getDogsByBreedUC(query)
            if (filteredDog != null) {
                if (!filteredDog.dogImages.isNullOrEmpty()) {
                    messageList.postValue(filteredDog!!)
                    rvVisibility.postValue(true)
                    isLoading.postValue(false)
                }
            } else {
                rvVisibility.postValue(true)
                isLoading.postValue(false)
                messageList.postValue(null)
            }
        }
    }

}