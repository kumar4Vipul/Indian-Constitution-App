package com.appbusters.robinpc.constitutionofindia.di.module

import android.content.Context
import com.appbusters.robinpc.constitutionofindia.di.scope.ConstitutionAppScope
import com.appbusters.robinpc.constitutionofindia.utils.ConstitutionPreferences
import com.google.gson.Gson
import dagger.Module
import dagger.Provides

@Module(includes = [ContextModule::class, NetworkModule::class])
class SharedPreferenceModule {

    @Provides
    @ConstitutionAppScope
    fun sharedPreferenceUtil(context: Context, gson: Gson): ConstitutionPreferences {
        return ConstitutionPreferences(context, gson)
    }

}