package com.appbusters.robinpc.constitutionofindia.di.component

import com.appbusters.robinpc.constitutionofindia.data.database.AppDatabase
import com.appbusters.robinpc.constitutionofindia.di.module.DatabaseModule
import com.appbusters.robinpc.constitutionofindia.di.module.JsonModule
import com.appbusters.robinpc.constitutionofindia.di.module.SharedPreferenceModule
import com.appbusters.robinpc.constitutionofindia.di.module.UtilsModule
import com.appbusters.robinpc.constitutionofindia.di.scope.ConstitutionAppScope
import com.appbusters.robinpc.constitutionofindia.utils.ConstitutionPreferences
import com.google.gson.Gson
import dagger.Component
import java.io.InputStream

@ConstitutionAppScope
@Component(modules = [SharedPreferenceModule::class, UtilsModule::class, DatabaseModule::class, JsonModule::class])
interface ConstitutionAppComponent {

    fun getGson(): Gson
    fun constitutionPreferences(): ConstitutionPreferences
    fun getDatabase(): AppDatabase
    fun getInputStream(): InputStream

}