package com.example.alkeparking.utils

class AlkeparkingConstants {
    companion object {
        // Messages
        const val MESSAGE_WELCOME = "Welcome to AlkeParking!"
        const val MESSAGE_ERROR_CHECK_IN = "Sorry, the check-in has failed"
        const val MESSAGE_ERROR_CHECKOUT = "Sorry, the check-out has failed"

        // Values
        const val PARKING_SPACE_LIMIT = 20
        const val FEE_MINIMUM_TIME = 120.00
        const val FEE_EXCESS_TIME = 15.00
        const val FEE_EXCESS_AMOUNT_PER_TIME = 5
        const val FEE_DISCOUNTED_PERCENTAGE = 0.85
        const val MINUTES_IN_MILLISECONDS = 60000.00
    }
}