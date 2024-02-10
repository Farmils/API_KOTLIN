package com.example.dao.MeasurementTypes

import com.example.dao.DatabaseFactory.dbQuery
import com.example.dao.Sensors.SensorDaoImpl
import com.example.models.Measurement_type
import com.example.models.Measurement_types
import com.example.models.SensorType
import com.example.models.Sensor_types
import org.jetbrains.exposed.sql.ResultRow
import org.jetbrains.exposed.sql.SqlExpressionBuilder.eq
import org.jetbrains.exposed.sql.select

class MeasurementTypeDaoImpl:MeasurementTypeDaoFacade {
    private fun resultRowToMeasurement_type(row: ResultRow) = Measurement_type(type_id = row[Measurement_types.type_id], type_name =  row[Measurement_types.type_name], type_formula = row[Measurement_types.type_formula], type_unit = row[Measurement_types.type_unit])
    override suspend fun findByTypeId(type_id: Int): Measurement_type?=dbQuery {
        Measurement_types.select{Measurement_types.type_id eq type_id}.map(::resultRowToMeasurement_type).singleOrNull()
    }

    override suspend fun findByTypeName(type_name: String): Measurement_type?=dbQuery {
        Measurement_types.select{Measurement_types.type_name eq type_name}.map(::resultRowToMeasurement_type).singleOrNull()
    }

    override suspend fun findByTypeUnit(type_unit: String): Measurement_type?=dbQuery {
        Measurement_types.select{Measurement_types.type_unit eq type_unit}.map(::resultRowToMeasurement_type).singleOrNull()
    }

    override suspend fun findByTypeFormula(type_formula: String): Measurement_type?=dbQuery {
        Measurement_types.select{Measurement_types.type_formula eq type_formula}.map(::resultRowToMeasurement_type).singleOrNull()
    }
}
val measurementDao = MeasurementTypeDaoImpl()