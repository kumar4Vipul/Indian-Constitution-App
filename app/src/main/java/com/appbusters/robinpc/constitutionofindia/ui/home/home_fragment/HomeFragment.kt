package com.appbusters.robinpc.constitutionofindia.ui.home.home_fragment

import android.app.Activity
import android.content.Intent
import androidx.recyclerview.widget.LinearLayoutManager
import com.appbusters.robinpc.constitutionofindia.ConstitutionApp

import com.appbusters.robinpc.constitutionofindia.R
import com.appbusters.robinpc.constitutionofindia.utils.ZoomOutPageTransformer
import com.appbusters.robinpc.constitutionofindia.data.model.Category
import com.appbusters.robinpc.constitutionofindia.di.component.fragment.DaggerHomeFragmentComponent
import com.appbusters.robinpc.constitutionofindia.di.module.fragment.HomeFragmentModule
import com.appbusters.robinpc.constitutionofindia.ui.base.BaseFragment
import com.appbusters.robinpc.constitutionofindia.ui.home.home_fragment.adapter.CategoriesListAdapter
import com.appbusters.robinpc.constitutionofindia.ui.home.home_fragment.adapter.FeaturedPagerAdapter
import com.appbusters.robinpc.constitutionofindia.ui.intermediate.IntermediateActivity
import com.appbusters.robinpc.constitutionofindia.ui.listing.ListingActivity
import com.appbusters.robinpc.constitutionofindia.ui.reading.ReadingActivity
import com.appbusters.robinpc.constitutionofindia.utils.Constants
import com.appbusters.robinpc.constitutionofindia.utils.Constants.Companion.CATEGORY_AMENDMENTS
import com.appbusters.robinpc.constitutionofindia.utils.Constants.Companion.CATEGORY_PARTS
import com.appbusters.robinpc.constitutionofindia.utils.Constants.Companion.CATEGORY_PREAMBLE
import com.appbusters.robinpc.constitutionofindia.utils.Constants.Companion.CATEGORY_SCHEDULES
import kotlinx.android.synthetic.main.fragment_home.*
import javax.inject.Inject

class HomeFragment : BaseFragment(), CategoriesListAdapter.CategoryClickListener {

    @Inject
    lateinit var categoriesAdapter: CategoriesListAdapter

    @Inject
    lateinit var featuredPagerAdapter: FeaturedPagerAdapter

    override fun getLayoutResId(): Int {
        return R.layout.fragment_home
    }

    companion object {
        fun newInstance() = HomeFragment()
    }

    override fun setup() {
        setComponent()
        setFeaturedPagerAdapter()
        setCategoriesAdapter()
    }

    private fun setComponent() {
        activity?.let {
            DaggerHomeFragmentComponent.builder()
                    .constitutionAppComponent(ConstitutionApp.get(it).constitutionAppComponent())
                    .homeFragmentModule(HomeFragmentModule(childFragmentManager))
                    .build().injectHomeFragment(this)
        }
    }

    private fun setFeaturedPagerAdapter() {
        featuredViewPager.adapter = featuredPagerAdapter
        featuredViewPager.setPageTransformer(false, ZoomOutPageTransformer())
        dotPagerIndicator.setViewPager(featuredViewPager)
    }

    private fun setCategoriesAdapter() {
        categoriesAdapter.setCategoryClickListener(this)
        categoriesRecycler.adapter = categoriesAdapter
        categoriesRecycler.layoutManager = LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)
        categoriesAdapter.submitList(getCategoriesList())
    }

    private fun getCategoriesList(): MutableList<Category> {
        val categoriesList = ArrayList<Category>()
        categoriesList.add(Category(R.color.schedules_color, CATEGORY_SCHEDULES))
        categoriesList.add(Category(R.color.parts_color, CATEGORY_PARTS))
        categoriesList.add(Category(R.color.amendment_color, CATEGORY_AMENDMENTS))
        categoriesList.add(Category(R.color.preamble_color, CATEGORY_PREAMBLE))
        return categoriesList
    }

    override fun onCategoryClicked(category: Category) {
        context?.let {

            var intent: Intent? = null

            when(category.name) {
                CATEGORY_PREAMBLE -> intent = ReadingActivity.newIntent(it, Constants.PREAMBLE_ID)
                CATEGORY_PARTS -> intent = IntermediateActivity.newIntent(it, category.name)
                CATEGORY_SCHEDULES, CATEGORY_AMENDMENTS -> intent = ListingActivity.newIntent(it, category.name)
            }

            startActivity(intent)
            (it as Activity).overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left)
        }
    }
}
