package com.appbusters.robinpc.constitutionofindia.di.module.activity

import android.content.Context
import androidx.fragment.app.FragmentManager
import com.appbusters.robinpc.constitutionofindia.di.scope.PerFragmentScope
import com.appbusters.robinpc.constitutionofindia.ui.home.adapter.HomeFragmentAdapter
import dagger.Module
import dagger.Provides

@Module
class HomeActivityModule(
        private val fragmentManager: FragmentManager,
        private val onLoadCompleteListener: HomeFragmentAdapter.OnLoadCompleteListener,
        private val onSyncCompleteListener: HomeFragmentAdapter.OnSyncCompleteListener
) {

    @Provides
    @PerFragmentScope
    fun homePagerAdapter(): HomeFragmentAdapter {
        val adapter = HomeFragmentAdapter(fragmentManager)
        adapter.setLoadCompleteListener(onLoadCompleteListener)
        adapter.setOnSyncCompleteListener(onSyncCompleteListener)
        return adapter
    }
}