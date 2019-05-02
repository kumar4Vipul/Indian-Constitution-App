package com.appbusters.robinpc.constitutionofindia.di.module

import com.appbusters.robinpc.constitutionofindia.di.scope.ConstitutionAppScope
import com.google.gson.Gson
import dagger.Module
import dagger.Provides

@Module
class NetworkModule {

    @Provides
    @ConstitutionAppScope
    fun gson(): Gson {
        return Gson()
    }
}