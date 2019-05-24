package com.appbusters.robinpc.constitutionofindia.ui.home

import android.content.Context
import android.content.Intent
import android.widget.ImageView
import androidx.core.content.ContextCompat
import androidx.viewpager.widget.ViewPager
import com.appbusters.robinpc.constitutionofindia.ConstitutionApp
import com.appbusters.robinpc.constitutionofindia.R
import com.appbusters.robinpc.constitutionofindia.di.component.activity.DaggerHomeActivityComponent
import com.appbusters.robinpc.constitutionofindia.di.module.activity.HomeActivityModule
import com.appbusters.robinpc.constitutionofindia.ui.base.BaseActivity
import com.appbusters.robinpc.constitutionofindia.ui.home.adapter.HomeFragmentsAdapter
import kotlinx.android.synthetic.main.activity_home.*
import javax.inject.Inject

class HomeActivity : BaseActivity(), ViewPager.OnPageChangeListener {

    @Inject
    lateinit var homePagerAdapter: HomeFragmentsAdapter

    companion object {
        const val HOME_PAGE = 0
        const val BOOKMARKS_PAGE = 1

        fun newIntent(context: Context): Intent {
            return Intent(context, HomeActivity::class.java)
        }
    }

    override fun getLayoutResId(): Int {
        return R.layout.activity_home
    }

    override fun setup() {
        setStatusBarColor(R.color.home_status_bar)
        setComponent()
        setViewPager()
        setClickListeners()
        setOtherListeners()
    }

    private fun setComponent() {
        DaggerHomeActivityComponent.builder()
                .constitutionAppComponent(ConstitutionApp.get(this).constitutionAppComponent())
                .homeActivityModule(HomeActivityModule(supportFragmentManager))
                .build().injectHomeActivity(this)
    }

    private fun setViewPager() {
        homeFragmentsPager.adapter = homePagerAdapter
    }

    private fun setClickListeners() {
        homeButton.setOnClickListener {
            highlightNavigation(it as ImageView)
            homeFragmentsPager.currentItem = HOME_PAGE
        }
        bookmarksButton.setOnClickListener {
            highlightNavigation(it as ImageView)
            homeFragmentsPager.currentItem = BOOKMARKS_PAGE
        }
    }

    private fun setOtherListeners() {
        homeFragmentsPager.addOnPageChangeListener(this)
    }

    private fun highlightNavigation(view: ImageView) {
        when(view) {
            homeButton -> {
                homeButton.setImageDrawable(ContextCompat.getDrawable(this, R.drawable.ic_home_filled))
                bookmarksButton.setImageDrawable(ContextCompat.getDrawable(this, R.drawable.ic_bookmark))
            }
            bookmarksButton -> {
                homeButton.setImageDrawable(ContextCompat.getDrawable(this, R.drawable.ic_home))
                bookmarksButton.setImageDrawable(ContextCompat.getDrawable(this, R.drawable.ic_bookmark_filled))
            }
        }
    }

    override fun onPageScrollStateChanged(state: Int) {
    }

    override fun onPageScrolled(position: Int, positionOffset: Float, positionOffsetPixels: Int) {
    }

    override fun onPageSelected(position: Int) {
        when(position) {
            HOME_PAGE -> highlightNavigation(homeButton)
            BOOKMARKS_PAGE -> highlightNavigation(bookmarksButton)
        }
    }
}
