package com.appbusters.robinpc.constitutionofindia.ui.home

import android.app.Activity
import android.app.NotificationChannel
import android.app.NotificationManager
import android.view.View
import android.widget.ImageView
import android.widget.Toast
import androidx.core.content.ContextCompat
import androidx.viewpager.widget.ViewPager
import com.appbusters.robinpc.constitutionofindia.ConstitutionApp
import com.appbusters.robinpc.constitutionofindia.R
import com.appbusters.robinpc.constitutionofindia.di.component.activity.DaggerHomeActivityComponent
import com.appbusters.robinpc.constitutionofindia.di.module.activity.HomeActivityModule
import com.appbusters.robinpc.constitutionofindia.ui.base.BaseActivity
import com.appbusters.robinpc.constitutionofindia.ui.home.adapter.HomeFragmentAdapter
import es.dmoral.toasty.Toasty
import kotlinx.android.synthetic.main.activity_home.*
import java.util.*
import javax.inject.Inject
import android.app.PendingIntent
import android.content.Context
import android.content.Intent
import androidx.core.app.NotificationCompat
import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.graphics.Color
import android.graphics.drawable.Drawable
import android.net.Uri
import android.os.Build
import android.util.Log
import androidx.core.app.NotificationManagerCompat
import androidx.work.PeriodicWorkRequest
import androidx.work.WorkManager
import com.appbusters.robinpc.constitutionofindia.other.BookNotificationWorker
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.gif.GifDrawable
import com.bumptech.glide.request.target.*
import com.bumptech.glide.request.target.Target
import com.bumptech.glide.request.transition.Transition
import java.util.concurrent.TimeUnit

class HomeActivity : BaseActivity(), ViewPager.OnPageChangeListener,
        HomeFragmentAdapter.OnLoadCompleteListener, HomeFragmentAdapter.OnSyncCompleteListener {

    private var wasLoadingShowed = false
    private var wasSyncCompleted = false

    @Inject
    lateinit var homePagerAdapter: HomeFragmentAdapter

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
        showNotification()
    }

    private fun setComponent() {
        DaggerHomeActivityComponent.builder()
                .constitutionAppComponent(ConstitutionApp.get(this).constitutionAppComponent())
                .homeActivityModule(HomeActivityModule(supportFragmentManager))
                .build().injectHomeActivity(this)
    }

    private fun setViewPager() {
        homePagerAdapter.setLoadCompleteListener(this)
        homePagerAdapter.setOnSyncCompleteListener(this)
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
            Toasty.success(this, getString(R.string.data_sync_success), Toast.LENGTH_SHORT, true).show();

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

//    private var CHANNEL_ID = "IC"
//    private var CHANNEL_NAME = "BOOK CHANNEL"
//    private var CHANNEL_DESCRIPTION = "Showing daily book recommendations for law students."
//    private var NOTIFICATION_ID = 1
//
//    private var bookTitle = "Autobiography of Malcolm X"
//    private var contentText = "Today's book recommendation - "
//    private var coverLink = "https://images-na.ssl-images-amazon.com/images/I/81kQBRCqt-L.jpg"
//    private var bookLink = "https://www.amazon.in/gp/product/0345350685/ref=as_li_qf_asin_il_tl?ie=UTF8&tag=robillo-21&creative=24630&linkCode=as2&creativeASIN=0345350685&linkId=7800799743968d0f13ce9071d3e05761"
//    private var bookDescription = "In the searing pages of this classic autobiography, originally published in 1964, Malcolm X, the Muslim leader, firebrand, and anti-integrationist, tells the extraordinary story of his life and the growth of the Black Muslim movement."

    private fun showNotification() {

//        val workManager = WorkManager.getInstance()
//        val bookRequests =
//                PeriodicWorkRequest.Builder(BookNotificationWorker::class.java, 15, TimeUnit.MINUTES).build()
//
//        workManager.getWorkInfoByIdLiveData(bookRequests.id).observe(this, androidx.lifecycle.Observer {
//            it?.let {
//                Log.e("tag", "work info status ${it.state}")
//            }
//        })
//
//        workManager.enqueue(bookRequests)

//        val intent = Intent(this, HomeActivity::class.java).apply {
//            flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
//        }
//
//        val pendingIntent: PendingIntent = PendingIntent.getActivity(this, 0, intent, 0)
//        val affiliateIntent = PendingIntent.getActivity(this, 1, getAffiliateIntent(), 0)
//
//        val builder = NotificationCompat.Builder(this, CHANNEL_ID)
//                .setSmallIcon(R.mipmap.ic_launcher_round)
//                .setColor(Color.parseColor("#CE372E"))
//                .setContentTitle(bookTitle)
//                .setContentText(contentText.plus(bookDescription))
//                .setContentIntent(pendingIntent)
//                .setPriority(NotificationCompat.PRIORITY_DEFAULT)
//                .addAction(R.drawable.ic_baseline_search_24px, getString(R.string.view_book), pendingIntent)
//                .addAction(R.drawable.ic_cart, getString(R.string.buy_on_amazon), affiliateIntent)
//
//        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
//            val importance = NotificationManager.IMPORTANCE_DEFAULT
//            val channel = NotificationChannel(CHANNEL_ID, CHANNEL_NAME, importance).apply {
//                description = CHANNEL_DESCRIPTION
//            }
//            // Register the channel with the system
//            val notificationManager: NotificationManager =
//                    getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager
//            notificationManager.createNotificationChannel(channel)
//        }
//
//        Glide.with(this)
//                .asBitmap()
//                .load(coverLink)
//                .centerCrop()
//                .into(object : CustomTarget<Bitmap>(){
//                    override fun onResourceReady(resource: Bitmap, transition: Transition<in Bitmap>?) {
//                        //TODO: attach bitmap
//                        builder.setStyle(NotificationCompat.BigPictureStyle().bigPicture(resource))
//
//                        with(NotificationManagerCompat.from(this@HomeActivity)) {
//                            notify(NOTIFICATION_ID, builder.build())
//                        }
//                    }
//                    override fun onLoadCleared(placeholder: Drawable?) {}
//                })
    }

//    private fun getAffiliateIntent(): Intent {
//        val affiliateUrl = bookLink
//        val intent = Intent(Intent.ACTION_VIEW)
//        intent.data = Uri.parse(affiliateUrl)
//        return intent
//    }
}
