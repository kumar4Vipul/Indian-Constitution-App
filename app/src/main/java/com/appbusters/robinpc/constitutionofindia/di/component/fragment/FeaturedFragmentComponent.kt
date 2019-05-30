package com.appbusters.robinpc.constitutionofindia.di.component.fragment

import com.appbusters.robinpc.constitutionofindia.di.component.ConstitutionAppComponent
import com.appbusters.robinpc.constitutionofindia.di.module.ViewModelFactoryModule
import com.appbusters.robinpc.constitutionofindia.di.module.ViewModelModule
import com.appbusters.robinpc.constitutionofindia.di.scope.PerFragmentScope
import com.appbusters.robinpc.constitutionofindia.ui.home.fragments.home_fragment.featured_fragment.FeaturedFragment
import dagger.Component

@PerFragmentScope
@Component(modules = [ViewModelFactoryModule::class, ViewModelModule::class],
        dependencies = [ConstitutionAppComponent::class])
interface FeaturedFragmentComponent {

    fun injectFeaturedFragment(featuredFragment: FeaturedFragment)

}