package com.appbusters.robinpc.constitutionofindia.ui.home

import android.util.Log
import android.view.View
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
import java.lang.IllegalStateException
import javax.inject.Inject
import java.util.*


class HomeActivity : BaseActivity(), ViewPager.OnPageChangeListener, HomeFragmentsAdapter.OnLoadCompleteListener {

    @Inject
    lateinit var homePagerAdapter: HomeFragmentsAdapter

    private var wasLoadingShowed = false

    companion object {
        const val HOME_PAGE = 0
        const val BOOKMARKS_PAGE = 1
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
        homePagerAdapter.setLoadCompleteListener(this)
        homeFragmentsPager.adapter = homePagerAdapter
    }

    private fun setClickListeners() {
        loadingScreen.setOnClickListener {
            Log.e("tag", "loading clicked")
        }
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

    override fun onLoadComplete() {
        if(!wasLoadingShowed) {
            loadingStatusTv.text = getString(R.string.load_complete)

            startHideTimer()
        }
    }

    private fun startHideTimer() {
        Timer().schedule(object : TimerTask() {
            override fun run() {
                hideLoadingLayout()
            }
        }, 2000)
    }

    private fun hideLoadingLayout() {
        runOnUiThread {
            try {
                lottieAnimationView.pauseAnimation()
                loadingScreen.visibility = View.GONE
                wasLoadingShowed = true
            }
            catch (e: IllegalStateException) {}
        }
    }
}
