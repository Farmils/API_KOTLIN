package com.example.dao.MeasurementTypes

import com.example.models.Measurement_type
import com.example.models.Sensor

interface MeasurementTypeDaoFacade {
    suspend fun findByTypeId(type_id:Int): Measurement_type?
    suspend fun findByTypeName(type_name:String): Measurement_type?
    suspend fun findByTypeUnit(type_unit:String): Measurement_type?
    suspend fun findByTypeFormula(type_formula:String): Measurement_type?
}