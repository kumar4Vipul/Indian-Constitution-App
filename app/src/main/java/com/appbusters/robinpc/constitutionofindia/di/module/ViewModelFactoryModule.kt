package com.appbusters.robinpc.constitutionofindia.di.module

import androidx.lifecycle.ViewModelProvider
import com.appbusters.robinpc.constitutionofindia.utils.DaggerViewModelFactory
import dagger.Binds
import dagger.Module

@Module
abstract class ViewModelFactoryModule {
    @Binds
    abstract fun bindViewModelFactory(viewModelFactory: DaggerViewModelFactory): ViewModelProvider.Factory
}