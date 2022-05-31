package com.example.alkeparking

import com.example.alkeparking.models.Parking
import com.example.alkeparking.models.Vehicle
import com.example.alkeparking.models.VehicleType

fun main() {
    val parking = Parking(mutableSetOf<Vehicle>())
    val vehicleList = getSampleList()

    with(parking) {
        addVehicleList(vehicleList)

        remove(vehicleList[2])
        remove(vehicleList[5])
        remove(vehicleList[12])
        remove(vehicleList[2])

        printBalanceInformation()
        listVehicles()
    }
}

fun getSampleList() = listOf(
    Vehicle("AA111AA", VehicleType.CAR, discountCard = "DISCOUNT_CARD_001"),
    Vehicle("AA111AA", VehicleType.CAR),
    Vehicle("BB222BB", VehicleType.MOTORCYCLE),
    Vehicle("CC333CC", VehicleType.MINIBUS),
    Vehicle("DD444DD", VehicleType.BUS, discountCard = "DISCOUNT_CARD_002"),
    Vehicle("EE555EE", VehicleType.CAR, discountCard = "DISCOUNT_CARD_003"),
    Vehicle("FF666FF", VehicleType.MOTORCYCLE),
    Vehicle("GG777GG", VehicleType.MINIBUS),
    Vehicle("HH888HH", VehicleType.BUS, discountCard = "DISCOUNT_CARD_004"),
    Vehicle("II999II", VehicleType.CAR, discountCard = "DISCOUNT_CARD_005"),
    Vehicle("JJ111JJ", VehicleType.MOTORCYCLE),
    Vehicle("KK222KK", VehicleType.MINIBUS),
    Vehicle("LL333LL", VehicleType.BUS, discountCard = "DISCOUNT_CARD_006"),
    Vehicle("MM444MM", VehicleType.CAR, discountCard = "DISCOUNT_CARD_007"),
    Vehicle("NN555NN", VehicleType.MOTORCYCLE),
    Vehicle("OO666OO", VehicleType.MINIBUS),
    Vehicle("PP777PP", VehicleType.BUS, discountCard = "DISCOUNT_CARD_008"),
    Vehicle("QQ888QQ", VehicleType.CAR, discountCard = "DISCOUNT_CARD_009"),
    Vehicle("RR999RR", VehicleType.MOTORCYCLE),
    Vehicle("SS111SS", VehicleType.MINIBUS),
    Vehicle("TT222TT", VehicleType.BUS, discountCard = "DISCOUNT_CARD_010"),
    Vehicle("UU333UU", VehicleType.CAR, discountCard = "DISCOUNT_CARD_011"),
    Vehicle("VV444VV", VehicleType.MOTORCYCLE),
)