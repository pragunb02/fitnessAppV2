package com.fitness.mainfitnessapp.model

import java.util.UUID


data class Classes(
    val id: String = generateId(),
    val classId: String,
    val userId: String,
    val waitList: Boolean,
    val source: String,
    val preferredTime: String,
    val notes: String?
){
    companion object {
        private fun generateId():String{
            return UUID.randomUUID().toString()
        }
    }

}