package com.example.routes

import com.example.dao.MeasurementTypes.MeasurementTypeDaoImpl
import io.ktor.http.*
import io.ktor.server.application.*
import io.ktor.server.response.*
import io.ktor.server.routing.*

fun Route.measurementTypeRouting(measurementTypeService: MeasurementTypeDaoImpl){
    get("/measurement_type/{id?}"){
        val id = call.parameters["id"]?.toInt()
        if (id != null){
            val measurementTypeResult = measurementTypeService.findByTypeId(type_id = id)
            call.respond(measurementTypeResult!!)
        } else {
            call.respond(HttpStatusCode.BadRequest, "Invalid model parameter")
        }
    }
}