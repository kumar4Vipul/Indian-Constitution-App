package com.appbusters.robinpc.constitutionofindia.ui.home.home_fragment


import android.app.Activity
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.LinearLayoutManager

import com.appbusters.robinpc.constitutionofindia.R
import com.appbusters.robinpc.constitutionofindia.Utils.ZoomOutPageTransformer
import com.appbusters.robinpc.constitutionofindia.data.model.Category
import com.appbusters.robinpc.constitutionofindia.ui.base.BaseFragment
import com.appbusters.robinpc.constitutionofindia.ui.home.home_fragment.adapters.CategoriesListAdapter
import com.appbusters.robinpc.constitutionofindia.ui.home.home_fragment.adapters.FeaturedPagerAdapter
import com.appbusters.robinpc.constitutionofindia.ui.listing.ListingActivity
import kotlinx.android.synthetic.main.fragment_home.*

class HomeFragment : BaseFragment(), CategoriesListAdapter.CategoryClickListener {

    lateinit var categoriesAdapter: CategoriesListAdapter

    override fun getLayoutResId(): Int {
        return R.layout.fragment_home
    }

    companion object {
        fun newInstance() = HomeFragment()
    }

    override fun setup() {
        setFeaturedPagerAdapter()
        setCategoriesAdapter()
    }

    private fun setFeaturedPagerAdapter() {
        featuredViewPager.adapter = FeaturedPagerAdapter(childFragmentManager)
        featuredViewPager.setPageTransformer(false, ZoomOutPageTransformer())
        dotPagerIndicator.setViewPager(featuredViewPager)
    }

    private fun setCategoriesAdapter() {
        categoriesAdapter = CategoriesListAdapter(comparator())
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

    private fun comparator(): DiffUtil.ItemCallback<Category> {
        return object : DiffUtil.ItemCallback<Category>() {
            override fun areItemsTheSame(oldItem: Category, newItem: Category): Boolean {
                return oldItem.name == newItem.name
            }

            override fun areContentsTheSame(oldItem: Category, newItem: Category): Boolean {
                return oldItem == newItem
            }
        }
    }

    override fun onCategoryClicked(category: Category) {
        context?.let {
            startActivity(ListingActivity.newIntent(it))
            (it as Activity).overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left)
        }
    }
}
