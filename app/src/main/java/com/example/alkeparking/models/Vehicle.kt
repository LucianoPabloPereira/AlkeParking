package com.example.alkeparking.models

import java.util.Calendar

/**
 *   There is no duplicated items and there is no need an order for the list of items,
 *   a reference is used to look up items in the list instead of an indexed position.
 *
 *   The properties discount card and check-in time are setted at Vehicle class
 *
 *   The sign "?" To indicate that such property is nullable. Following that,
 *   the property is initiated the desired default value or null if not.
 **/
data class Vehicle(
    val plate: String,
    val type: VehicleType,
    val checkInTime: Calendar = Calendar.getInstance(),
    val discountCard: String? = null
) {

    override fun equals(other: Any?): Boolean {
        if (other is Vehicle) {
            return this.plate == other.plate
        }

        return super.equals(other)
    }

    override fun hashCode(): Int = this.plate.hashCode()
}
