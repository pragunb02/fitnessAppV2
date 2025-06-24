package com.fitness.mainfitnessapp.model

data class BookSlotRequest(
    val preferredTime: String,
    val notes: String? = null
)

data class BookSlotResponse(
    val bookingId: String,
    val status: String
)
