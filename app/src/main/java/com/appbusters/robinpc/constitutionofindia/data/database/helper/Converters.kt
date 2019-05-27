package com.appbusters.robinpc.constitutionofindia.data.database.helper

import androidx.room.TypeConverter
import com.google.gson.Gson

class Converters {

    @TypeConverter
    fun stringListToJson(value: List<String>?): String {
        return Gson().toJson(value)
    }

    @TypeConverter
    fun jsonToStringList(value: String?): List<String>? {
        value?.let {
            try {
                val objects: Array<String>? = Gson().fromJson(value, Array<String>::class.java)
                return objects?.toList()
            }
            catch (e: TypeCastException) {
                return null
            }
        } ?: run {
            return null
        }
    }

    @TypeConverter
    fun intListToJson(value: List<Int>?): String {
        return Gson().toJson(value)
    }

    @TypeConverter
    fun jsonToIntList(value: String): List<Int>? {
        val objects = Gson().fromJson(value, Array<Int>::class.java) as Array<Int>
        val list = objects.toList()
        return list
    }
}