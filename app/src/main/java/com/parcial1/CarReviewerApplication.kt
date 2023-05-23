package com.parcial1

import android.app.Application
import com.parcial1.data.cars
import com.parcial1.repositories.CarRepository

class CarReviewerApplication: Application() {
    val carRepository: CarRepository by lazy {
        CarRepository(cars)
    }
}