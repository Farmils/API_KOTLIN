package com.example.routes

import com.example.dao.Measurements.MeasurementsDaoImpl
import io.ktor.http.*
import io.ktor.server.application.*
import io.ktor.server.response.*
import io.ktor.server.routing.*

fun Route.measurementRouting(measurementService: MeasurementsDaoImpl){
    get("/measurements/{station?}"){
        val station = call.parameters["station"]?.toInt()
        if (station != null){
            val measurementTypeResult = measurementService.findByStation(station = station)
            call.respond(measurementTypeResult!!)
        } else {
            call.respond(HttpStatusCode.BadRequest, "Invalid model parameter")
        }
    }
}