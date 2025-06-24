package com.fitness.mainfitnessapp.inMemory

object InMemoryUserDb {
    private val users = mutableSetOf<String>("12345")
    fun insert(classId: String){
        users.add(classId)
    }
    fun all(): List<String> = users.toList()
    fun findUser(userId: String): String?{
        return all().firstOrNull{
            it == userId
        }
    }
}