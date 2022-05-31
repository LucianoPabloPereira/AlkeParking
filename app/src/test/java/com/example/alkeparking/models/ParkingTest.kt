package com.example.alkeparking.models

import androidx.test.ext.junit.runners.AndroidJUnit4
import com.example.alkeparking.VehiclesMock
import org.junit.Assert
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class ParkingTest {

    private val vehiclesMock by lazy { VehiclesMock() }

    private val parking by lazy { Parking(mutableSetOf<Vehicle>()) }

    @Test
    fun `test add vehicle array to parking list`() {
        val vehicleList = vehiclesMock.getSampleList()
        parking.addVehicleList(vehicleList)

        Assert.assertNotNull(parking.vehicles.find { parkedVehicle ->
            parkedVehicle.plate == "GG777GG"
        })
    }
}