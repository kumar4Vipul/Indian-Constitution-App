package com.appbusters.robinpc.constitutionofindia.di.module.activity

import androidx.fragment.app.FragmentManager
import com.appbusters.robinpc.constitutionofindia.di.scope.PerFragmentScope
import com.appbusters.robinpc.constitutionofindia.ui.home.adapter.HomeFragmentAdapter
import dagger.Module
import dagger.Provides

@Module
class HomeActivityModule(private val fragmentManager: FragmentManager) {

    @Provides
    @PerFragmentScope
    fun homePagerAdapter(): HomeFragmentAdapter {
        return HomeFragmentAdapter(fragmentManager)
    }
}