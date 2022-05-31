package com.example.alkeparking.models

import src.main.models.Vehicle
import java.util.*
import kotlin.math.ceil

private val FEE_MINIMUM = 120.00
private val FEE_EXCESS = 15.00
private val MINUTES_IN_MILISECONDS = 60000.00


data class ParkingSpace(var vehicle: Vehicle) {

    var parkedTime: Long = 0

    fun checkOutVehicle(plate: String) : Int {
        val spaceFee = calculateFee()
        onSuccess(spaceFee)
        return spaceFee
    }

    private fun calculateFee(): Int {
        val hasDiscountCard = vehicle.discountCard?.let { true } ?: false
        var fee = 0
        parkedTime = ((Calendar.getInstance().timeInMillis - vehicle.checkInTime.timeInMillis) / MINUTES_IN_MILISECONDS).toLong()
        if (parkedTime <= FEE_MINIMUM) {
            fee = vehicle.type.amount
        } else {
            fee = vehicle.type.amount
            val otherTime = ceil(((parkedTime - FEE_MINIMUM) / FEE_EXCESS)).toInt()
            fee += otherTime * 5
        }

        return calculateDiscount(hasDiscountCard, fee)
    }

    private fun calculateDiscount(hasDiscountCard: Boolean, fee: Int): Int =
        if (hasDiscountCard) ceil(fee - (fee * 0.15)).toInt() else fee

    private fun onSuccess(amount: Int) {
        println("Your fee is $amount Come back soon.")
    }

    fun onError() {
        println("Sorry, the check-out failed")
    }
}