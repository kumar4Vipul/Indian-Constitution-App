package com.appbusters.robinpc.constitutionofindia.ui.listing.tag_listing

import android.content.Context
import android.content.Intent
import com.appbusters.robinpc.constitutionofindia.R
import com.appbusters.robinpc.constitutionofindia.ui.base.BaseActivity

class TagChildrenActivity : BaseActivity() {

    companion object {
        fun newIntent(context: Context): Intent {
            return Intent(context, TagChildrenActivity::class.java)
        }
    }

    override fun getLayoutResId(): Int {
        return R.layout.activity_tag_children
    }

    override fun setup() {

    }

    override fun onBackPressed() {
        super.onBackPressed()
        overridePendingTransition(R.anim.slide_in_left, R.anim.slide_out_right)
    }
}
