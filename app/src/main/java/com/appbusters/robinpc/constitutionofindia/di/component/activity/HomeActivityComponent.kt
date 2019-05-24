package com.appbusters.robinpc.constitutionofindia.di.component.activity

import com.appbusters.robinpc.constitutionofindia.di.component.ConstitutionAppComponent
import com.appbusters.robinpc.constitutionofindia.di.module.ViewModelFactoryModule
import com.appbusters.robinpc.constitutionofindia.di.module.ViewModelModule
import com.appbusters.robinpc.constitutionofindia.di.module.activity.HomeActivityModule
import com.appbusters.robinpc.constitutionofindia.di.scope.PerFragmentScope
import com.appbusters.robinpc.constitutionofindia.ui.home.HomeActivity
import dagger.Component

@PerFragmentScope
@Component(modules = [HomeActivityModule::class, ViewModelFactoryModule::class, ViewModelModule::class],
        dependencies = [ConstitutionAppComponent::class])
interface HomeActivityComponent {

    fun injectHomeActivity(homeActivity: HomeActivity)

}