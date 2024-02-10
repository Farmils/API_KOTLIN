package com.example.dao.Sensors

import com.example.dao.DatabaseFactory.dbQuery
import com.example.models.Sensor
import com.example.models.Sensors
import org.jetbrains.exposed.sql.ResultRow
import org.jetbrains.exposed.sql.insert
import org.jetbrains.exposed.sql.select

class SensorDaoImpl: SensorDaoFacade {
    private fun resultRowToSensor(row:ResultRow) = Sensor(sensor_model =row[Sensors.sensor_model],sensor_type = row[Sensors.sensor_type])

    override suspend fun createSensor(sensor: Sensor): Sensor?=dbQuery {
        val insertStatement = Sensors.insert {
            it[Sensors.sensor_type]=sensor.sensor_type
            it[Sensors.sensor_model]=sensor.sensor_model

        }
        insertStatement.resultedValues?.singleOrNull()?.let(::resultRowToSensor)
    }

    override suspend fun findByModel(model: String): Sensor?=dbQuery{
        Sensors.select {Sensors.sensor_type eq model}.map(::resultRowToSensor).singleOrNull()

    }

}
val sensorDao = SensorDaoImpl()