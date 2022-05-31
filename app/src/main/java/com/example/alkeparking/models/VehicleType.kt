package com.example.alkeparking.models

//The vehicle type will not change so it is set to constant.
enum class VehicleType(val amount: Int){
    CAR(20),
    MOTORCYCLE(15),
    MINIBUS(25),
    BUS(30)
}