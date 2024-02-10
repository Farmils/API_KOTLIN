package com.example.routes


import com.example.Services.SensorService
import io.ktor.server.application.*
import io.ktor.server.response.*
import io.ktor.server.routing.*

fun Route.sensorRouting(sensorService: SensorService){
    get("/sensors/{model?}"){
        val model = call.parameters["model"]
        val sensorResult=sensorService.findByModel(model = model!!)
        call.respond(sensorResult!!)
    }
}