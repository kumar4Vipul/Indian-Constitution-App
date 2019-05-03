package com.appbusters.robinpc.constitutionofindia.ui.listing

import android.content.Context
import android.content.Intent
import com.appbusters.robinpc.constitutionofindia.R
import com.appbusters.robinpc.constitutionofindia.ui.base.BaseActivity
import com.appbusters.robinpc.constitutionofindia.utils.Constants.Companion.EXTRA_CATEGORY
import kotlinx.android.synthetic.main.activity_intermediate.*

class ListingActivity : BaseActivity() {

    lateinit var categoryName: String

    companion object {
        fun newIntent(context: Context, categoryName: String): Intent {
            val intent = Intent(context, ListingActivity::class.java)
            intent.putExtra(EXTRA_CATEGORY, categoryName)
            return intent
        }
    }

    override fun getLayoutResId(): Int {
        return R.layout.activity_listing
    }

    override fun setup() {
        setStatusBarColor(R.color.reading_status_bar)
        getIntentData()
        renderViewsForData()
    }

    private fun getIntentData() {
        categoryName = intent.getStringExtra(EXTRA_CATEGORY)
    }

    private fun renderViewsForData() {
        headerListingTv.text = categoryName
    }

    override fun onBackPressed() {
        super.onBackPressed()
        overridePendingTransition(R.anim.slide_in_left, R.anim.slide_out_right)
    }
}

