package com.example.routes
import com.example.Services.SensorTypeService
import io.ktor.http.*
import io.ktor.server.application.*
import io.ktor.server.response.*
import io.ktor.server.routing.*

fun Route.sensorTypeRouting(sensorTypeService: SensorTypeService){
    get("/sensor_type/{model?}"){
        val model = call.parameters["model"]?.toInt()
        if (model != null){
            val sensorTypeResult = sensorTypeService.findByModel(model = model)
            call.respond(sensorTypeResult!!)
        } else {
            call.respond(HttpStatusCode.BadRequest, "Invalid model parameter")
        }
    }
}