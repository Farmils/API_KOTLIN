package com.example.dao.Measurements

import com.example.models.Measurement
import com.example.models.Measurement_type
import com.example.models.Measurement_types
import org.jetbrains.exposed.sql.ResultRow

interface MeasurementsDaoFacade {
    suspend fun findByStation(station:Int): List<Measurement>?
    suspend fun findByMeasurementType(measurement_type:Int): Measurement?
    suspend fun findByMeasurementValue(measurement_value:Float): Measurement?
    suspend fun findBySensorModel(sensor_model:Int): Measurement?
}