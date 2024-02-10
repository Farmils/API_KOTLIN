package com.example.Services

import com.example.dao.Meteostations.MeteostationsDaoFacade
import com.example.dao.Meteostations.meteostationDao
import com.example.dao.Sensors.sensorDao
import com.example.models.Measurement_type
import com.example.models.Meteostation
import com.example.models.Meteostations


class MeteostationService(private val MeteostationsRepository: MeteostationsDaoFacade) {
    suspend fun findByStationId(station_id: Int): List<Meteostation>? {
        return MeteostationsRepository.findByStationId(station_id)
    }

    suspend fun findByStationName(station_name:String): List<Meteostation>? {
        return MeteostationsRepository.findByStationName(station_name)
    }
    suspend fun findByTMeteostationAddress(meteostation_address:String): List<Meteostation>? {
        return MeteostationsRepository.findByMeteostationAddress(meteostation_address)
    }
}
val meteostationService = MeteostationService(meteostationDao)