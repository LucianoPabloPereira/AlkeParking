package com.example.alkeparking.models

import com.example.alkeparking.utils.AlkeparkingConstants.Companion.FEE_DISCOUNTED_PERCENTAGE
import com.example.alkeparking.utils.AlkeparkingConstants.Companion.FEE_EXCESS_AMOUNT_PER_TIME
import com.example.alkeparking.utils.AlkeparkingConstants.Companion.FEE_EXCESS_TIME
import com.example.alkeparking.utils.AlkeparkingConstants.Companion.FEE_MINIMUM_TIME
import com.example.alkeparking.utils.AlkeparkingConstants.Companion.MESSAGE_ERROR_CHECKOUT
import com.example.alkeparking.utils.AlkeparkingConstants.Companion.MINUTES_IN_MILLISECONDS
import java.util.*
import kotlin.math.ceil

data class ParkingSpace(var vehicle: Vehicle) {

    fun checkOutVehicle() : Int {
        val spaceFee = calculateFee()
        onSuccess(spaceFee)
        return spaceFee
    }

    // Calculate and return the fee value
    private fun calculateFee(): Int {
        val hasDiscountCard = vehicle.discountCard?.let { true } ?: false
        val parkedTime = getParkedTime()
        var fee = vehicle.type.amount

        if (parkedTime > FEE_MINIMUM_TIME) {
            val otherTime = ceil(((parkedTime - FEE_MINIMUM_TIME) / FEE_EXCESS_TIME)).toInt()
            fee += otherTime * FEE_EXCESS_AMOUNT_PER_TIME
        }

        return calculateDiscount(hasDiscountCard, fee)
    }

    private fun getParkedTime() =
        ((Calendar.getInstance().timeInMillis - vehicle.checkInTime.timeInMillis) / MINUTES_IN_MILLISECONDS).toLong()

    // Calculate discounted value of fee if client has a discount card
    private fun calculateDiscount(hasDiscountCard: Boolean, fee: Int): Int =
        if (hasDiscountCard) ceil(fee * FEE_DISCOUNTED_PERCENTAGE).toInt() else fee

    // Prints the checkout message with the fee amount to pay
    private fun onSuccess(fee: Int) {
        println("Your fee is $fee Come back soon.")
    }

    // Prints an error message when a vehicle couldn´t be removed
    fun onError() {
        println(MESSAGE_ERROR_CHECKOUT)
    }
}