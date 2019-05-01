package com.appbusters.robinpc.constitutionofindia.ui.listing

import android.content.Context
import android.content.Intent
import com.appbusters.robinpc.constitutionofindia.R
import com.appbusters.robinpc.constitutionofindia.ui.base.BaseActivity

class ListingActivity : BaseActivity() {

    companion object {
        fun newIntent(context: Context): Intent {
            return Intent(context, ListingActivity::class.java)
        }
    }

    override fun getLayoutResId(): Int {
        return R.layout.activity_listing
    }

    override fun setup() {
        setStatusBarColor(R.color.reading_status_bar)
    }

    override fun onBackPressed() {
        super.onBackPressed()
        overridePendingTransition(R.anim.slide_in_left, R.anim.slide_out_right)
    }
}

