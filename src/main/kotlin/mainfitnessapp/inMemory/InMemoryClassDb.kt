package com.fitness.mainfitnessapp.inMemory

import com.fitness.mainfitnessapp.model.BookSlotResponse
import com.fitness.mainfitnessapp.model.Classes

object InMemoryClassDb {
//    val inMemoryClasses : MutableList<String> = mutableListOf()
    private val classes = mutableSetOf<Classes>()
//    fun all(): List<String> = classes.toList()
    fun findClass(classId: String): Classes?{
        return classes.firstOrNull{
           it.classId==classId
        }
    }
    fun save(classId:String, userId:String, waitList: Boolean, source:String, preferredTime:String, notes:String?): BookSlotResponse{
        val entity = Classes(
            classId       = classId,
            userId        = userId,
            waitList      = waitList,
            source        = source,
            preferredTime = preferredTime,
            notes         = notes
        )
        classes += entity
        return BookSlotResponse(
            bookingId = entity.id,
            status    = "Confirmed"
        )
    }
}