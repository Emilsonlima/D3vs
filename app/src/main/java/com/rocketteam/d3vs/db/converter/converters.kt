package com.rocketteam.d3vs.db.converter

import androidx.room.TypeConverter
import java.time.LocalDate

class converters {

    @TypeConverter
    fun LocalDateToString(Value: LocalDate?): String? {
        return Value.let { it.toString() }
    }

    @TypeConverter
    fun StringToLocalDate(Value: String?): LocalDate {
        return if (Value != "null") LocalDate.parse(Value) else LocalDate.now()
    }

}