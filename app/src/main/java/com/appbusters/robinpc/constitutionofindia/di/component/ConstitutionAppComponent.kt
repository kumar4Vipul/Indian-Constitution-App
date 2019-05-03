package com.appbusters.robinpc.constitutionofindia.di.component

import com.appbusters.robinpc.constitutionofindia.di.module.SharedPreferenceModule
import com.appbusters.robinpc.constitutionofindia.di.module.UtilsModule
import com.appbusters.robinpc.constitutionofindia.di.scope.ConstitutionAppScope
import com.appbusters.robinpc.constitutionofindia.utils.ConstitutionPreferences
import com.google.gson.Gson
import dagger.Component
import java.io.InputStream

@ConstitutionAppScope
@Component(modules = [SharedPreferenceModule::class, UtilsModule::class])
interface ConstitutionAppComponent {
    fun getGson(): Gson
    fun constitutionPreferences(): ConstitutionPreferences
}