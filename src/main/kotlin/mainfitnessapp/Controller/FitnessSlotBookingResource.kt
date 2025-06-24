package com.fitness.mainfitnessapp.Controller

import com.fitness.mainfitnessapp.model.BookSlotRequest
import com.fitness.mainfitnessapp.server.BookingManager
import javax.inject.Inject
import javax.validation.Valid
import javax.ws.rs.Consumes
import javax.ws.rs.DefaultValue
import javax.ws.rs.GET
import javax.ws.rs.POST
import javax.ws.rs.Path
import javax.ws.rs.PathParam
import javax.ws.rs.Produces
import javax.ws.rs.QueryParam
import javax.ws.rs.core.MediaType
import javax.ws.rs.core.Response

@Path("/fitness")
class FitnessSlotBookingResource @Inject constructor(
    private val bookingManager : BookingManager
) {

    @GET
    @Path("/status/classId/{classId}")
    @Produces(MediaType.APPLICATION_JSON)
    fun getStatus(
        @PathParam("classId") classId: String,
        @QueryParam("userId") userId: String
    ) : Response {
        val classRes = bookingManager.findClassName(classId,userId)
        println("lplp")
        return Response.status(200).entity(classRes).build()
    }

    @POST
    @Path("/status/classes/{classId}/users/{userId}")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    fun saveStatus(
        @PathParam("classId") classId: String,
        @PathParam("userId") userId: String,
        @QueryParam("waitlist")
        @DefaultValue("false") waitlist: Boolean,
        @QueryParam("source")
        @DefaultValue("mobile") source: String,
        @Valid req : BookSlotRequest
    ) : Response {
        val res = bookingManager.insertClassUserDetails(
            classId,
            userId,
            waitlist,
            source,
            req.preferredTime,
            req.notes
        )
        return Response.status(200).entity(res).build()
    }

}