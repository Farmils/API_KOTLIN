package com.example.dao.Meteostations

import com.example.models.Meteostation

interface MeteostationsDaoFacade {
    suspend fun findByStationId(station_id:Int): List<Meteostation>?
    suspend fun findByStationName(station_name:String): List<Meteostation>?
    suspend fun findByMeteostationAddress(meteostation_address:String): List<Meteostation>?
}