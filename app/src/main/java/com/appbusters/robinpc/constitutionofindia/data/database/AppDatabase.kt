package com.appbusters.robinpc.constitutionofindia.data.database

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.appbusters.robinpc.constitutionofindia.data.dao.ReadElementDao
import com.appbusters.robinpc.constitutionofindia.data.dao.TagDao
import com.appbusters.robinpc.constitutionofindia.data.database.helper.Converters
import com.appbusters.robinpc.constitutionofindia.data.model.ReadElement
import com.appbusters.robinpc.constitutionofindia.data.model.Tag

@Database(entities = [ReadElement::class, Tag::class], version = 1, exportSchema = false)
@TypeConverters(Converters::class)
abstract class AppDatabase: RoomDatabase() {

    abstract fun readElementDao(): ReadElementDao
    abstract fun tagDao(): TagDao

}