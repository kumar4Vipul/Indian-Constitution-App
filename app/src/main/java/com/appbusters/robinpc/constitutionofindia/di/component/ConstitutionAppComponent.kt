package com.appbusters.robinpc.constitutionofindia.di.component

import com.appbusters.robinpc.constitutionofindia.di.module.SharedPreferenceModule
import com.appbusters.robinpc.constitutionofindia.di.scope.ConstitutionAppScope
import com.appbusters.robinpc.constitutionofindia.utils.ConstitutionPreferences
import com.google.gson.Gson
import dagger.Component

@ConstitutionAppScope
@Component(modules = [SharedPreferenceModule::class])
interface ConstitutionAppComponent {
    fun constitutionPreferences(): ConstitutionPreferences
    fun getGson(): Gson
}