package com.appbusters.robinpc.constitutionofindia.di.module

import android.content.Context
import com.appbusters.robinpc.constitutionofindia.di.qualifier.MainDatabaseString
import com.appbusters.robinpc.constitutionofindia.di.scope.ConstitutionAppScope
import com.appbusters.robinpc.constitutionofindia.utils.Constants
import dagger.Module
import dagger.Provides
import java.io.InputStream

@Module(includes = [ContextModule::class])
class JsonModule {

    @Provides
    @ConstitutionAppScope
    fun tagsDatabaseInputStream(@MainDatabaseString databaseFilePath: String, context: Context): InputStream {
        return context.assets.open(databaseFilePath)
    }

    @Provides
    @MainDatabaseString
    @ConstitutionAppScope
    fun mainDatabaseFilePath(): String {
        return Constants.MAIN_DB_PATH
    }
}