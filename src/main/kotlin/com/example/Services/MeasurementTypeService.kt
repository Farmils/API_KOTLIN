package com.example.Services

import com.example.dao.MeasurementTypes.MeasurementTypeDaoFacade
import com.example.dao.MeasurementTypes.measurementDao
import com.example.models.Measurement_type
import com.example.models.Measurement_types
import com.example.models.SensorType

class MeasurementTypeService(private val MeasurementTypeRepository:MeasurementTypeDaoFacade) {
    suspend fun findByTypeId(type_id: Int): Measurement_type? {
        return MeasurementTypeRepository.findByTypeId(type_id)
    }

    suspend fun findByTypeName(type_name:String): Measurement_type? {
        return MeasurementTypeRepository.findByTypeName(type_name)


    }
    suspend fun findByTypeUnit(type_unit:String): Measurement_type? {
        return MeasurementTypeRepository.findByTypeUnit(type_unit)
    }
    suspend fun findByTypeFormula(type_formula:String): Measurement_type? {
        return MeasurementTypeRepository.findByTypeFormula(type_formula)
    }
}
val measurementTypeService = measurementDao