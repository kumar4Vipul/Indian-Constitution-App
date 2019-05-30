package com.appbusters.robinpc.constitutionofindia.di.component.activity

import com.appbusters.robinpc.constitutionofindia.di.component.ConstitutionAppComponent
import com.appbusters.robinpc.constitutionofindia.di.module.ViewModelFactoryModule
import com.appbusters.robinpc.constitutionofindia.di.module.ViewModelModule
import com.appbusters.robinpc.constitutionofindia.di.module.activity.SavedCategoryActivityModule
import com.appbusters.robinpc.constitutionofindia.di.scope.PerFragmentScope
import com.appbusters.robinpc.constitutionofindia.ui.listing.saved_category_listing.SavedCategoryActivity
import dagger.Component

@PerFragmentScope
@Component(modules = [SavedCategoryActivityModule::class, ViewModelFactoryModule::class, ViewModelModule::class],
        dependencies = [ConstitutionAppComponent::class])
interface SavedCategoryActivityComponent {

    fun injectSavedCategoryActivity(savedCategoryActivity: SavedCategoryActivity)

}