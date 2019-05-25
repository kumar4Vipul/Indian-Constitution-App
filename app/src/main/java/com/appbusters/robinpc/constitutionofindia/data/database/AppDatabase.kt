package com.appbusters.robinpc.constitutionofindia.data.database

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.appbusters.robinpc.constitutionofindia.data.dao.ReadElementDao
import com.appbusters.robinpc.constitutionofindia.data.database.helper.Converters
import com.appbusters.robinpc.constitutionofindia.data.model.ReadElement

@Database(entities = [ReadElement::class], version = 1)
@TypeConverters(Converters::class)
abstract class AppDatabase: RoomDatabase() {

    abstract fun readElementDao(): ReadElementDao

}