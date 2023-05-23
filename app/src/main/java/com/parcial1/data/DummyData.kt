package com.parcial1.data

import com.parcial1.data.models.CarModel

//model 1
val model = "Serie 6"
val brand = "BMW"

//model 2

val model2 = "Class E"
val brand2 = "Mercedes-Benz"

var cars = mutableListOf(
    CarModel(model, brand),
    CarModel(model2, brand2)
)