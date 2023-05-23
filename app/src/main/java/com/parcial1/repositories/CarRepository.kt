package com.parcial1.repositories

import com.parcial1.data.models.CarModel

class CarRepository(private val cars: MutableList<CarModel>) {
    fun getCars() = cars;

    fun addCar(car: CarModel) = cars.add(car)
}