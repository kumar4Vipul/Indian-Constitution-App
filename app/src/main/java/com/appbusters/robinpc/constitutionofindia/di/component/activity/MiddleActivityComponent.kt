package com.appbusters.robinpc.constitutionofindia.di.component.activity

import com.appbusters.robinpc.constitutionofindia.di.component.ConstitutionAppComponent
import com.appbusters.robinpc.constitutionofindia.di.module.ViewModelFactoryModule
import com.appbusters.robinpc.constitutionofindia.di.module.ViewModelModule
import com.appbusters.robinpc.constitutionofindia.di.module.activity.MiddleActivityModule
import com.appbusters.robinpc.constitutionofindia.di.scope.PerFragmentScope
import com.appbusters.robinpc.constitutionofindia.ui.intermediate.MiddleActivity
import dagger.Component


@PerFragmentScope
@Component(modules = [MiddleActivityModule::class, ViewModelFactoryModule::class, ViewModelModule::class],
        dependencies = [ConstitutionAppComponent::class])
interface MiddleActivityComponent {

    fun injectMiddleActivity(activity: MiddleActivity)
}