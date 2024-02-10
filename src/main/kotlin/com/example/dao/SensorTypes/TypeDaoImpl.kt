package com.example.dao.SensorTypes

import com.example.dao.DatabaseFactory.dbQuery
import com.example.dao.Sensors.SensorDaoImpl
import com.example.models.*
import org.jetbrains.exposed.sql.ResultRow
import org.jetbrains.exposed.sql.SqlExpressionBuilder.eq
import org.jetbrains.exposed.sql.select

class TypeDaoImpl:TypeDaoFacade {
    private fun resultRowToType(row:ResultRow) = SensorType(sensor_model =row[Sensor_types.sensor_model], type_id =  row[Sensor_types.type_id])
    override suspend fun findByType(sensorType: Int): SensorType? = dbQuery {
        Sensor_types.select{Sensor_types.type_id eq sensorType}.map(::resultRowToType).singleOrNull()
    }

    override suspend fun findByModel(model: Int): List<SensorType> = dbQuery {
        Sensor_types.select{Sensor_types.sensor_model eq model}.map(::resultRowToType)
    }

}
val sensorTypeDao = TypeDaoImpl()
