package com.example.models

import kotlinx.serialization.Serializable
import kotlinx.serialization.json.Json
import org.jetbrains.exposed.sql.Table

import org.jetbrains.exposed.sql.json.json

@Serializable
data class Point(val latitude:Float, val longitude:Float)

@Serializable
data class Meteostation(
    val station_id:Int,
    val station_cord:Point,
    val station_z:String,
    val station_address:String,
    val station_name:String
)
object Meteostations: Table(){
    val station_id=integer("station_id").autoIncrement()
    val station_cord=json<Point>("station_cord",Json)
    val station_z=varchar("station_z", length = 255)
    val station_address=varchar("station_address", length = 255)
    val station_name=varchar("station_name", length = 255)
    override val primaryKey: PrimaryKey
        get() = PrimaryKey(station_id)
}