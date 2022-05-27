package src.main.models

import com.example.alkeparking.models.ParkingSpace

data class Parking(val vehicles: MutableSet<Vehicle>) {

    private var parkingInformation: Pair<Int, Int> = Pair(0, 0)
    private var totalEarning = 0
    private var totalVehiclesCheckedOut = 0

    fun addVehicle(vehicle: Vehicle) : Boolean {
        return if (vehicles.size < PARKING_SPACE_LIMIT) vehicles.add(vehicle) else false
    }

    fun addVehicleList(vehicles: List<Vehicle>) {
        vehicles.forEach {
            if (addVehicle(it)) println(MESSAGE_WELCOME) else println(MESSAGE_ERROR_CHECKIN)
        }
    }

    fun remove(vehicle: Vehicle){
        val parkingSpace = ParkingSpace(vehicle)
        val vehicleToRemove = vehicles.find { it.plate == vehicle.plate }
        vehicleToRemove?.let {
            totalEarning += parkingSpace.checkOutVehicle(vehicle.plate)
            totalVehiclesCheckedOut++
            parkingInformation = Pair(totalEarning, totalVehiclesCheckedOut)
            vehicles.remove(vehicleToRemove)
        } ?: parkingSpace.onError()
    }

    fun listVehicles() {
        vehicles.map { println(it.plate) }
    }

    fun getBalanceInformation() {
        println("${parkingInformation.second} vehicles have checked out and have earnings of $${parkingInformation.first}")
    }

    companion object {
        const val PARKING_SPACE_LIMIT = 20
        const val MESSAGE_WELCOME = "Welcome to AlkeParking!"
        const val MESSAGE_ERROR_CHECKIN = "Sorry, the check-in has failed"
    }
}