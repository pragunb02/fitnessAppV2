package mainfitnessapp// FitnessModule.kt
import com.fitness.mainfitnessapp.FitnessSlotBookingConfiguration
import com.google.inject.AbstractModule

class FitnessModule(private val configuration: FitnessSlotBookingConfiguration) : AbstractModule() {
//    override fun configure() {
//        bind(FitnessSlotBookingConfiguration::class.java).toInstance(configuration)
//        // Add other bindings here
//    }
}