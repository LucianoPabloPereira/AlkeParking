package com.example.alkeparking.models

import com.example.alkeparking.utils.AlkeparkingConstants.Companion.MESSAGE_ERROR_CHECK_IN
import com.example.alkeparking.utils.AlkeparkingConstants.Companion.MESSAGE_WELCOME
import com.example.alkeparking.utils.AlkeparkingConstants.Companion.PARKING_SPACE_LIMIT

data class Parking(val vehicles: MutableSet<Vehicle>) {

    private var parkingInformation: Pair<Int, Int> = Pair(0, 0)
    private var totalEarning = 0
    private var totalVehiclesCheckedOut = 0

    // Add a single vehicle object to parking list if is there any place available.
    fun addVehicle(vehicle: Vehicle): Boolean {
        return if (vehicles.size < PARKING_SPACE_LIMIT) vehicles.add(vehicle) else false
    }

    // Add multiple vehicles
    fun addVehicleList(vehicles: List<Vehicle>) {
        vehicles.forEach {
            if (addVehicle(it)) println(MESSAGE_WELCOME) else println(MESSAGE_ERROR_CHECK_IN)
        }
    }

    // Removes vehicle from Parking list
    fun remove(vehicle: Vehicle) {
        val parkingSpace = ParkingSpace(vehicle)
        val vehicleToRemove = vehicles.find { it.plate == vehicle.plate }
        vehicleToRemove?.let {
            setBalanceInformation(parkingSpace.checkOutVehicle())
            vehicles.remove(vehicleToRemove)
        } ?: parkingSpace.onError()
    }

    // Print a list with all vehicle plates actually inside Parking
    fun listVehicles() {
        vehicles.map { println(it.plate) }
    }

    // Prints information about the total number of registered cars and the total profit obtained.
    fun printBalanceInformation() {
        println("${parkingInformation.second} vehicles have checked out and have earnings of $${parkingInformation.first}")
    }

    // Sets total values for total balance and number of registered vehicles to parkingInformation Pair
    private fun setBalanceInformation(checkOutVehicle: Int) {
        totalEarning += checkOutVehicle
        totalVehiclesCheckedOut++
        parkingInformation = Pair(totalEarning, totalVehiclesCheckedOut)
    }
}