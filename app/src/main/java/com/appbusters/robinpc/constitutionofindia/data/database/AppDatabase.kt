package com.appbusters.robinpc.constitutionofindia.data.database

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.appbusters.robinpc.constitutionofindia.data.dao.BookLinkDao
import com.appbusters.robinpc.constitutionofindia.data.dao.PartDao
import com.appbusters.robinpc.constitutionofindia.data.dao.ReadElementDao
import com.appbusters.robinpc.constitutionofindia.data.dao.TagDao
import com.appbusters.robinpc.constitutionofindia.data.database.helper.Converters
import com.appbusters.robinpc.constitutionofindia.data.model.BookLink
import com.appbusters.robinpc.constitutionofindia.data.model.Part
import com.appbusters.robinpc.constitutionofindia.data.model.ReadElement
import com.appbusters.robinpc.constitutionofindia.data.model.Tag

@Database(entities = [ReadElement::class, Tag::class, Part::class, BookLink::class], version = 2, exportSchema = false)
@TypeConverters(Converters::class)
abstract class AppDatabase: RoomDatabase() {

    abstract fun readElementDao(): ReadElementDao
    abstract fun tagDao(): TagDao
    abstract fun partDao(): PartDao
    abstract fun bookLinkDao(): BookLinkDao

}