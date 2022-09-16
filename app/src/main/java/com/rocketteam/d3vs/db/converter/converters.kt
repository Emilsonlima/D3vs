package com.rocketteam.d3vs.db.converter

import androidx.room.TypeConverter
import java.time.LocalDate
import java.time.format.DateTimeFormatter

class converters {

    @TypeConverter
    fun LocalDateToString(Value: LocalDate?): String? {
        return Value.let { it.toString() }
    }

    @TypeConverter
    fun StringToLocalDate(Value: String?): LocalDate {
        return if (Value != "null") LocalDate.parse(Value) else LocalDate.now()
    }

    @TypeConverter
    fun StringToLocalDate(Value: Boolean?): Int {
        return Value.let {
            when (it) {
                false -> 0
                else -> 1
            }
        }
    }

    @TypeConverter
    fun LocalDateToString(Value: Int?): Boolean {
        return Value.let { it!! > 0 }
    }

}