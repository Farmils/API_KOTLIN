package com.example.dao.SensorTypes

import com.example.models.Sensor
import com.example.models.SensorType

interface TypeDaoFacade {
    suspend fun findByType(sensorType:Int): SensorType?
    suspend fun findByModel(model:Int): List<SensorType>?
}