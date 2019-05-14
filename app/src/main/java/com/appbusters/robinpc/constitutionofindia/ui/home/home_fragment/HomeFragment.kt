package com.appbusters.robinpc.constitutionofindia.ui.home.home_fragment

import android.app.Activity
import android.content.Intent
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.appbusters.robinpc.constitutionofindia.ConstitutionApp

import com.appbusters.robinpc.constitutionofindia.R
import com.appbusters.robinpc.constitutionofindia.utils.ZoomOutPageTransformer
import com.appbusters.robinpc.constitutionofindia.data.model.Category
import com.appbusters.robinpc.constitutionofindia.data.model.ReadElement
import com.appbusters.robinpc.constitutionofindia.di.component.fragment.DaggerHomeFragmentComponent
import com.appbusters.robinpc.constitutionofindia.di.module.fragment.HomeFragmentModule
import com.appbusters.robinpc.constitutionofindia.ui.base.BaseFragment
import com.appbusters.robinpc.constitutionofindia.ui.home.home_fragment.adapter.CategoriesListAdapter
import com.appbusters.robinpc.constitutionofindia.ui.home.home_fragment.adapter.FeaturedPagerAdapter
import com.appbusters.robinpc.constitutionofindia.ui.intermediate.MiddleActivity
import com.appbusters.robinpc.constitutionofindia.ui.listing.ListingActivity
import com.appbusters.robinpc.constitutionofindia.ui.reading.ReadingActivity
import com.appbusters.robinpc.constitutionofindia.utils.Constants.Companion.AMENDMENTS_END_INDEX
import com.appbusters.robinpc.constitutionofindia.utils.Constants.Companion.AMENDMENTS_START_INDEX
import com.appbusters.robinpc.constitutionofindia.utils.Constants.Companion.CATEGORY_AMENDMENTS
import com.appbusters.robinpc.constitutionofindia.utils.Constants.Companion.CATEGORY_PARTS
import com.appbusters.robinpc.constitutionofindia.utils.Constants.Companion.CATEGORY_PREAMBLE
import com.appbusters.robinpc.constitutionofindia.utils.Constants.Companion.CATEGORY_SCHEDULES
import com.appbusters.robinpc.constitutionofindia.utils.Constants.Companion.PREAMBLE_INDEX
import com.appbusters.robinpc.constitutionofindia.utils.Constants.Companion.SCHEDULES_END_INDEX
import com.appbusters.robinpc.constitutionofindia.utils.Constants.Companion.SCHEDULES_START_INDEX
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
        const val SPAN_COUNT = 2

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
        categoriesRecycler.layoutManager = GridLayoutManager(context, SPAN_COUNT, RecyclerView.VERTICAL, false)
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
                CATEGORY_PARTS ->
                    intent = MiddleActivity.newIntent(it, category.name)
                CATEGORY_PREAMBLE ->
                    intent = ListingActivity.newIntent(it, category.name, category.name, PREAMBLE_INDEX, PREAMBLE_INDEX)
                CATEGORY_SCHEDULES ->
                    intent = ListingActivity.newIntent(it, category.name, category.name, SCHEDULES_START_INDEX, SCHEDULES_END_INDEX)
                CATEGORY_AMENDMENTS ->
                    intent = ListingActivity.newIntent(it, category.name, category.name, AMENDMENTS_START_INDEX, AMENDMENTS_END_INDEX)
            }

            startActivity(intent)
            (it as Activity).overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left)
        }
    }
}
