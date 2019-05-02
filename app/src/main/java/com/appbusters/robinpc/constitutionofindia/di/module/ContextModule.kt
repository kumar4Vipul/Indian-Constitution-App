package com.appbusters.robinpc.constitutionofindia.di.module

import android.content.Context
import com.appbusters.robinpc.constitutionofindia.di.scope.ConstitutionAppScope
import dagger.Module
import dagger.Provides

@Module
class ContextModule(val context: Context) {

    @Provides
    @ConstitutionAppScope
    fun context(): Context {
        return context
    }
}