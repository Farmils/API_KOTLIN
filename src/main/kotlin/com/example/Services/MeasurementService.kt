package com.example.Services

import com.example.dao.Measurements.MeasurementsDaoFacade
import com.example.dao.Measurements.measurementsDao
import com.example.models.Measurement
class MeasurementService(private val MeasurementRepository:MeasurementsDaoFacade) {
    suspend fun findByStation(station:Int): List<Measurement>?{
        return MeasurementRepository.findByStation(station)
    }
    suspend fun findByMeasurementType(measurement_type:Int): Measurement?{
        return MeasurementRepository.findByMeasurementType(measurement_type)
    }
    suspend fun findByMeasurementValue(measurement_value:Float): Measurement?{
        return MeasurementRepository.findByMeasurementValue(measurement_value)
    }
    suspend fun findBySensorModel(sensor_model:Int): Measurement?{
        return MeasurementRepository.findBySensorModel(sensor_model)
    }

}
val measurementService = measurementsDao