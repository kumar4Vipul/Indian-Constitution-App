package com.appbusters.robinpc.constitutionofindia.di.component.fragment

import com.appbusters.robinpc.constitutionofindia.di.component.ConstitutionAppComponent
import com.appbusters.robinpc.constitutionofindia.di.module.ViewModelFactoryModule
import com.appbusters.robinpc.constitutionofindia.di.module.ViewModelModule
import com.appbusters.robinpc.constitutionofindia.di.module.fragment.HomeFragmentModule
import com.appbusters.robinpc.constitutionofindia.di.scope.PerFragmentScope
import com.appbusters.robinpc.constitutionofindia.ui.home.home_fragment.HomeFragment
import dagger.Component

@PerFragmentScope
@Component(modules = [HomeFragmentModule::class, ViewModelFactoryModule::class, ViewModelModule::class],
        dependencies = [ConstitutionAppComponent::class])
interface HomeFragmentComponent {
    fun injectHomeFragment(homeFragment: HomeFragment)
}