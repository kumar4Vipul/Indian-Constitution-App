package com.appbusters.robinpc.constitutionofindia.di.module

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import com.appbusters.robinpc.constitutionofindia.data.database.AppDatabase
import com.appbusters.robinpc.constitutionofindia.di.scope.ConstitutionAppScope
import com.appbusters.robinpc.constitutionofindia.utils.Constants.Companion.APP_DATABASE
import dagger.Module
import dagger.Provides

@Module(includes = [ContextModule::class])
class DatabaseModule {

    @Provides
    @ConstitutionAppScope
    fun appDatabase(context: Context): AppDatabase {
        return Room.databaseBuilder(context, AppDatabase::class.java, APP_DATABASE).build()
    }
}