package com.appbusters.robinpc.constitutionofindia.di.component.activity

import com.appbusters.robinpc.constitutionofindia.di.component.ConstitutionAppComponent
import com.appbusters.robinpc.constitutionofindia.di.module.ViewModelFactoryModule
import com.appbusters.robinpc.constitutionofindia.di.module.ViewModelModule
import com.appbusters.robinpc.constitutionofindia.di.module.activity.ListingActivityModule
import com.appbusters.robinpc.constitutionofindia.di.scope.PerFragmentScope
import com.appbusters.robinpc.constitutionofindia.ui.listing.ListingActivity
import dagger.Component

@PerFragmentScope
@Component(modules = [ListingActivityModule::class, ViewModelFactoryModule::class, ViewModelModule::class],
        dependencies = [ConstitutionAppComponent::class])
interface ListingActivityComponent {

    fun injectListingActivity(activity: ListingActivity)
}