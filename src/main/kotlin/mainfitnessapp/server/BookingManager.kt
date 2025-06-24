package com.fitness.mainfitnessapp.server

import com.fitness.mainfitnessapp.dal.SlotBookingRepository
import com.fitness.mainfitnessapp.model.BookSlotResponse
import com.fitness.mainfitnessapp.model.Classes
import javax.inject.Inject

class BookingManager @Inject constructor(
    private val slotBookingRepository: SlotBookingRepository
){
    fun findClassName(classId:String, userId:String): Classes {
        return slotBookingRepository.findClassName(classId,userId);
    }
    fun insertClassUserDetails(
        classId : String,
        userId: String,
        waitList: Boolean,
        source:String,
        preferredTime:String,
        notes:String?
    ) : BookSlotResponse {
        return slotBookingRepository.insertClass(classId,userId,waitList,source,preferredTime,notes)
    }
}