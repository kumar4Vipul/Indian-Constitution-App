package com.appbusters.robinpc.constitutionofindia.ui.home.fragments.home_fragment.featured_fragment

import android.app.Activity
import android.graphics.drawable.GradientDrawable
import android.os.Bundle
import android.util.Log
import androidx.core.content.ContextCompat
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import com.appbusters.robinpc.constitutionofindia.ConstitutionApp
import com.appbusters.robinpc.constitutionofindia.R
import com.appbusters.robinpc.constitutionofindia.data.model.BookLink
import com.appbusters.robinpc.constitutionofindia.di.component.fragment.DaggerFeaturedFragmentComponent
import com.appbusters.robinpc.constitutionofindia.di.component.fragment.DaggerHomeFragmentComponent
import com.appbusters.robinpc.constitutionofindia.di.module.fragment.HomeFragmentModule
import com.appbusters.robinpc.constitutionofindia.utils.Constants.Companion.EXTRA_INDEX
import com.appbusters.robinpc.constitutionofindia.utils.Constants.Companion.FEATURED_PREAMBLE_INDEX
import com.appbusters.robinpc.constitutionofindia.utils.Constants.Companion.FEATURED_SAVED_BY_YOU_INDEX
import com.appbusters.robinpc.constitutionofindia.utils.Constants.Companion.FEATURED_YOUR_PROGRESS_INDEX
import com.appbusters.robinpc.constitutionofindia.ui.base.BaseFragment
import com.appbusters.robinpc.constitutionofindia.ui.home.fragments.home_fragment.HomeFragmentViewModel
import com.appbusters.robinpc.constitutionofindia.ui.listing.category_listing.CategoryListingActivity
import com.appbusters.robinpc.constitutionofindia.utils.Constants.Companion.CATEGORY_PREAMBLE
import com.appbusters.robinpc.constitutionofindia.utils.Constants.Companion.COUNT_DAYS
import com.appbusters.robinpc.constitutionofindia.utils.Constants.Companion.PREAMBLE_INDEX
import com.appbusters.robinpc.constitutionofindia.utils.Constants.Companion.SUNDAY
import kotlinx.android.synthetic.main.fragment_featured.*
import java.util.*
import javax.inject.Inject

class FeaturedFragment : BaseFragment() {

    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory

    private  var pageIndex = -1
    private var dayNumber: Int = -1

    private lateinit var calendar: Calendar
    private lateinit var viewModel: FeaturedFragmentViewModel

    companion object {
        fun newInstance(index: Int): FeaturedFragment {
            val fragment = FeaturedFragment()
            val bundle = Bundle()
            bundle.putInt(EXTRA_INDEX, index)
            fragment.arguments = bundle
            return fragment
        }
    }

    override fun getLayoutResId(): Int {
        return R.layout.fragment_featured
    }

    override fun setup() {
        calendar = Calendar.getInstance()

        setComponent()
        getArgumentValues()
        setObservers()
        setClickListeners()
    }

    private fun setComponent() {
        activity?.let {
            DaggerFeaturedFragmentComponent.builder()
                    .constitutionAppComponent(ConstitutionApp.get(it).constitutionAppComponent())
                    .build().injectFeaturedFragment(this)
        }

        viewModel = ViewModelProviders.of(this, viewModelFactory).get(FeaturedFragmentViewModel::class.java)
    }

    private fun getArgumentValues() {
        dayNumber = calendar.get(Calendar.DAY_OF_YEAR)
        pageIndex = arguments!!.getInt(EXTRA_INDEX)
    }

    private fun setObservers() {
        Log.e("tag", "day of year ${getDayIdForPage()}")
        viewModel.getBookById(getDayIdForPage()).observe(this, androidx.lifecycle.Observer {
            it?.let {
                renderViews(it)
            }
        })
    }

    private fun getDayIdForPage(): Int {
        return dayNumber  + (pageIndex - COUNT_DAYS + 1)
    }

    private fun renderViews(bookLink: BookLink) {
        //TODO: render views
    }

    private fun getDrawable(resStartColor: Int, resEndColor: Int): GradientDrawable {
        return GradientDrawable(GradientDrawable.Orientation.TL_BR, intArrayOf(
                getColorFromRes(resStartColor),
                getColorFromRes(resEndColor)
        ))
    }

    private fun getColorFromRes(res: Int): Int {
        context?.let {
            return ContextCompat.getColor(it, res)
        }
        return res
    }

    private fun setClickListeners() {
        fullPage.setOnClickListener {
            when(pageIndex) {
                FEATURED_PREAMBLE_INDEX -> {
                    context?.let {
                        startActivity(
                                CategoryListingActivity.newIntent(
                                        it, CATEGORY_PREAMBLE, CATEGORY_PREAMBLE, PREAMBLE_INDEX, PREAMBLE_INDEX
                                )
                        )
                        (it as Activity).overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left)
                    }
                }
            }
        }
    }
}
