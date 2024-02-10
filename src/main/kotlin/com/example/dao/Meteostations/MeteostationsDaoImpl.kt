package com.example.dao.Meteostations

import com.example.dao.DatabaseFactory.dbQuery
import com.example.dao.Measurements.MeasurementsDaoImpl
import com.example.models.Measurement
import com.example.models.Measurements
import com.example.models.Meteostation
import com.example.models.Meteostations
import org.jetbrains.exposed.sql.ResultRow
import org.jetbrains.exposed.sql.SqlExpressionBuilder.eq
import org.jetbrains.exposed.sql.select

class MeteostationsDaoImpl:MeteostationsDaoFacade {
    private fun resultRowToMeateostations(row: ResultRow) = Meteostation(station_id = row[Meteostations.station_id], station_cord = row[Meteostations.station_cord], station_z = row[Meteostations.station_z], station_address = row[Meteostations.station_address], station_name = row[Meteostations.station_name])

    override suspend fun findByStationId(station_id: Int): List<Meteostation> = dbQuery {
        Measurements.select{Meteostations.station_id eq station_id}.map(::resultRowToMeateostations)
    }

    override suspend fun findByStationName(station_name: String): List<Meteostation> = dbQuery {
        Measurements.select{Meteostations.station_name eq station_name}.map(::resultRowToMeateostations)
    }

    override suspend fun findByMeteostationAddress(meteostation_address: String): List<Meteostation> = dbQuery {
        Measurements.select{Meteostations.station_address eq meteostation_address}.map(::resultRowToMeateostations)
    }
}
val meteostationDao= MeteostationsDaoImpl()