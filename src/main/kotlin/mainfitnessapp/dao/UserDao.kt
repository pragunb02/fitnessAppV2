package com.fitness.mainfitnessapp.dao

import com.fitness.mainfitnessapp.inMemory.InMemoryUserDb

class UserDao {
    fun findUser(userId:String): String?{
        return InMemoryUserDb.findUser(userId)
    }
}