package com.parcial1.ui.car.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider.AndroidViewModelFactory.Companion.APPLICATION_KEY
import androidx.lifecycle.viewmodel.initializer
import androidx.lifecycle.viewmodel.viewModelFactory
import com.parcial1.CarReviewerApplication
import com.parcial1.data.models.CarModel
import com.parcial1.repositories.CarRepository

class CarViewModel(private val repository: CarRepository): ViewModel() {

    var model = MutableLiveData("")
    var brand = MutableLiveData("")
    var status = MutableLiveData("")

    fun getCars() = repository.getCars()

    fun addCars(car: CarModel) = repository.addCar(car)

    fun createCar() {
        if(!validateData()){
            status.value = WRONG_INFORMATION
            return
        }

        val car = CarModel(
            model.value!!,
            brand.value!!
        )

        addCars(car)
        clearData()

        status.value = CAR_CREATED
    }

    private fun validateData() : Boolean {
        when{
            model.value.isNullOrEmpty() -> return false
            brand.value.isNullOrEmpty() -> return false
         }
        return true
    }

    fun clearData() {
        model.value = ""
        brand.value = ""
    }

    fun clearStatus () {
        status.value = INACTIVE
    }

    fun setSelectedCar(car: CarModel) {
        model.value = car.model
        brand.value = car.brand
    }

    companion object {
        val Factory = viewModelFactory {
            initializer {
                val app = this[APPLICATION_KEY] as CarReviewerApplication
                CarViewModel(app.carRepository)
            }
        }
        const val CAR_CREATED = "Car created"
        const val WRONG_INFORMATION = "Wrong information"
        const val INACTIVE = ""
    }
}
