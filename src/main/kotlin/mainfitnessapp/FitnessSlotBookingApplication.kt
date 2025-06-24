package com.fitness.mainfitnessapp

import com.fasterxml.jackson.module.kotlin.KotlinModule
import com.fitness.mainfitnessapp.Controller.FitnessSlotBookingResource
import io.dropwizard.Application
import io.dropwizard.setup.Environment
import com.google.inject.Guice
import io.dropwizard.setup.Bootstrap
import mainfitnessapp.FitnessModule

class FitnessSlotBookingApplication : Application<FitnessSlotBookingConfiguration>() {
    override fun initialize(bootstrap: Bootstrap<FitnessSlotBookingConfiguration>) {
        // Wire in Kotlin support before anything else uses the mapper
        bootstrap.objectMapper.registerModule(KotlinModule())
    }
    override fun run(p0: FitnessSlotBookingConfiguration, environment: Environment) {

//        use this when we didn't have any dependency in FitnessSlotBookingResource file
//        val resource = FitnessSlotBookingResource()
//        environment.jersey().register(resource)

        val injector = Guice.createInjector(FitnessModule(p0))

        getResourceClass().forEach {
            environment.jersey().register(
                injector.getInstance(it)
            )
        }

    }

    fun getResourceClass() = listOf(
        FitnessSlotBookingResource::class.java
    )

    companion object {
        @JvmStatic
        fun main(args : Array<String>){
            FitnessSlotBookingApplication().run(*args)
        }
    }

}