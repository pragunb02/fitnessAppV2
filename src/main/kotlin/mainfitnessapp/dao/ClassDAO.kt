package com.fitness.mainfitnessapp.dao

import com.fitness.mainfitnessapp.inMemory.InMemoryClassDb
import com.fitness.mainfitnessapp.model.BookSlotResponse
import com.fitness.mainfitnessapp.model.Classes


class ClassDAO {
    fun findClass(classId:String): Classes?{
        return InMemoryClassDb.findClass(classId)
    }
    fun insert(classId:String, userId:String, waitList: Boolean, source:String, preferredTime:String, notes:String?): BookSlotResponse{
        return InMemoryClassDb.save(classId,userId,waitList,source,preferredTime,notes)
    }
}