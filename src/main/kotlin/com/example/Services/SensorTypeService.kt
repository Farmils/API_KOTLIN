package com.example.Services

import com.example.dao.SensorTypes.TypeDaoFacade
import com.example.dao.SensorTypes.sensorTypeDao
import com.example.dao.Sensors.sensorDao
import com.example.models.Sensor
import com.example.models.SensorType

class SensorTypeService(private val SensorTypeRepository:TypeDaoFacade) {
    suspend fun findByType(sensorType:Int): SensorType? {
        return SensorTypeRepository.findByType(sensorType)
    }
    suspend fun findByModel(model:Int): List<SensorType>? {
        return SensorTypeRepository.findByModel(model)
    }
}
val sensorTypeService=SensorTypeService(sensorTypeDao)
