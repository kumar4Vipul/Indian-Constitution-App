package com.appbusters.robinpc.constitutionofindia.ui.home

import android.view.View
import androidx.viewpager.widget.ViewPager
import com.appbusters.robinpc.constitutionofindia.R
import com.appbusters.robinpc.constitutionofindia.di.component.activity.DaggerHomeActivityComponent
import com.appbusters.robinpc.constitutionofindia.di.module.activity.HomeActivityModule
import com.appbusters.robinpc.constitutionofindia.ui.base.BaseActivity
import com.appbusters.robinpc.constitutionofindia.ui.home.adapter.HomeFragmentAdapter
import kotlinx.android.synthetic.main.activity_home.*
import java.util.*
import javax.inject.Inject

class HomeActivity : BaseActivity(),
        ViewPager.OnPageChangeListener,
        HomeFragmentAdapter.OnLoadCompleteListener,
        HomeFragmentAdapter.OnSyncCompleteListener {

    private var wasLoadingShowed = false

    @Inject
    lateinit var homePagerAdapter: HomeFragmentAdapter

    companion object {
        const val HOME_PAGE = 0
        const val BOOKMARKS_PAGE = 1
        var wasSyncCompleted = false
    }

    override fun setup() {
        setComponent()
        setViewPager()
        setClickListeners()
        setPageChangeListener()
        setStatusBarColor(R.color.home_status_bar)
    }

    override fun onPageSelected(position: Int) {
        when(position) {
            HOME_PAGE -> setPageIcon(homeButton)
            BOOKMARKS_PAGE -> setPageIcon(bookmarksButton)
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

    override fun onSyncComplete() {
        if(!wasSyncCompleted)
            showSuccessToasty(getString(R.string.data_sync_success), WITH_ICON)

        wasSyncCompleted = true
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

    override fun onBackPressed() {
        if(homeFragmentsPager.currentItem == BOOKMARKS_PAGE)
            setPage(HOME_PAGE)

        else super.onBackPressed()
    }

    private fun setClickListeners() {
        homeButton.setOnClickListener {
            setPageIcon(it)
            setPage(HOME_PAGE)
        }
        bookmarksButton.setOnClickListener {
            setPageIcon(it)
            setPage(BOOKMARKS_PAGE)
        }
    }

    private fun setPageIcon(view: View) {
        when(view) {
            homeButton -> {
                homeButton.setImageDrawable(getDrawableForId(R.drawable.ic_home_filled))
                bookmarksButton.setImageDrawable(getDrawableForId(R.drawable.ic_bookmark))
            }
            bookmarksButton -> {
                homeButton.setImageDrawable(getDrawableForId(R.drawable.ic_home))
                bookmarksButton.setImageDrawable(getDrawableForId(R.drawable.ic_bookmark_filled))
            }
        }
    }

    private fun setPage(pageNumber: Int) {
        homeFragmentsPager.currentItem = pageNumber
    }

    private fun setPageChangeListener() {
        homeFragmentsPager.addOnPageChangeListener(this)
    }

    override fun getLayoutResId(): Int {
        return R.layout.activity_home
    }

    private fun setViewPager() {
        homeFragmentsPager.adapter = homePagerAdapter
    }

    private fun setComponent() {
        val component = DaggerHomeActivityComponent.builder()
                .constitutionAppComponent(getAppComponent())
                .homeActivityModule(getModule())
                .build()

        component.injectHomeActivity(this)
    }

    private fun getModule(): HomeActivityModule {
        return HomeActivityModule(
                supportFragmentManager,
                this,
                this
        )
    }

    override fun onPageScrollStateChanged(state: Int) {}

    override fun onPageScrolled(position: Int, offset: Float, offsetPixels: Int) {}

}