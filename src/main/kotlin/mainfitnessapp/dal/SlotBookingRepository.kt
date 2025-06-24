package com.fitness.mainfitnessapp.dal

import com.fitness.mainfitnessapp.dao.ClassDAO
import com.fitness.mainfitnessapp.dao.UserDao
import com.fitness.mainfitnessapp.model.BookSlotResponse
import com.fitness.mainfitnessapp.model.Classes
import javax.inject.Inject
import javax.ws.rs.NotFoundException

class SlotBookingRepository @Inject constructor(
    private val classDao : ClassDAO,
    private val userDao: UserDao
) {
    fun findClassName(classId: String, userId: String): Classes {
        val clazz = classDao.findClass(classId)
            ?: throw NotFoundException("Class $classId not found")

        val user = userDao.findUser(userId) ?:
        throw NotFoundException("User $userId not found")
        return clazz
    }

    fun insertClass(classId:String, userId:String, waitList: Boolean, source:String, preferredTime:String, notes:String?) : BookSlotResponse{
        return classDao.insert(classId,userId,waitList,source,preferredTime,notes)
    }
}