package com.example.dao.Measurements

import com.example.dao.DatabaseFactory.dbQuery
import com.example.models.Measurement
import com.example.models.Measurement_type
import com.example.models.Measurement_types
import com.example.models.Measurements
import io.ktor.util.reflect.*
import org.jetbrains.exposed.sql.ResultRow
import org.jetbrains.exposed.sql.SqlExpressionBuilder.eq
import org.jetbrains.exposed.sql.select

class MeasurementsDaoImpl:MeasurementsDaoFacade {
    private fun resultRowToMeasurements(row: ResultRow) = Measurement(station = row[Measurements.station], measurement_value =  row[Measurements.measurement_value], measurement_time = row[Measurements.measurement_time].toString(), measurement_type = row[Measurements.measurement_type], sensor_model = row[Measurements.sensor_model])
    override suspend fun findByStation(station: Int): List<Measurement> =dbQuery {
        Measurements.select{Measurements.station eq station}.map(::resultRowToMeasurements)
    }

    override suspend fun findByMeasurementType(measurement_type: Int): Measurement? =dbQuery  {
        Measurements.select{Measurements.measurement_type eq measurement_type}.map(::resultRowToMeasurements).singleOrNull()
    }

    override suspend fun findByMeasurementValue(measurement_value: Float): Measurement?=dbQuery  {
        Measurements.select{Measurements.measurement_value eq measurement_value}.map(::resultRowToMeasurements).singleOrNull()
    }

    override suspend fun findBySensorModel(sensor_model: Int): Measurement?=dbQuery  {
        Measurements.select{Measurements.sensor_model eq sensor_model}.map(::resultRowToMeasurements).singleOrNull()
    }


}
val measurementsDao=MeasurementsDaoImpl()