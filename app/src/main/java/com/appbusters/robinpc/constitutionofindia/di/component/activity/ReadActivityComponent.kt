package com.appbusters.robinpc.constitutionofindia.di.component.activity

import com.appbusters.robinpc.constitutionofindia.di.component.ConstitutionAppComponent
import com.appbusters.robinpc.constitutionofindia.di.module.ViewModelFactoryModule
import com.appbusters.robinpc.constitutionofindia.di.module.ViewModelModule
import com.appbusters.robinpc.constitutionofindia.di.module.activity.ReadActivityModule
import com.appbusters.robinpc.constitutionofindia.di.scope.PerFragmentScope
import com.appbusters.robinpc.constitutionofindia.ui.reading.ReadingActivity
import dagger.Component

@PerFragmentScope
@Component(modules = [ReadActivityModule::class, ViewModelFactoryModule::class, ViewModelModule::class],
        dependencies = [ConstitutionAppComponent::class])
interface ReadActivityComponent {

    fun injectReadingActivity(activity: ReadingActivity)
}