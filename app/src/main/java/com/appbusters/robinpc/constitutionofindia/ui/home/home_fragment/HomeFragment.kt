package com.appbusters.robinpc.constitutionofindia.ui.home.home_fragment

import android.app.Activity
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
import com.appbusters.robinpc.constitutionofindia.ui.listing.ListingActivity
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
        categoriesList.add(Category(R.color.schedules_color, getString(R.string.schedules_categories)))
        categoriesList.add(Category(R.color.parts_color, getString(R.string.parts_categories)))
        categoriesList.add(Category(R.color.amendment_color, getString(R.string.amendments_categories)))
        categoriesList.add(Category(R.color.preamble_color, getString(R.string.preamble_categories)))
        return categoriesList
    }

    override fun onCategoryClicked(category: Category) {
        context?.let {
            startActivity(ListingActivity.newIntent(it))
            (it as Activity).overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left)
        }
    }
}
