package com.appbusters.robinpc.constitutionofindia.ui.listing.tags_list

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.appbusters.robinpc.constitutionofindia.R
import com.appbusters.robinpc.constitutionofindia.ui.base.BaseActivity

class TagsListActivity : BaseActivity() {

    companion object {
        fun newIntent(context: Context): Intent {
            return Intent(context, TagsListActivity::class.java)
        }
    }

    override fun getLayoutResId(): Int {
        return R.layout.activity_tags_list
    }

    override fun setup() {

    }

    override fun onBackPressed() {
        super.onBackPressed()
        overridePendingTransition(R.anim.slide_in_left, R.anim.slide_out_right)
    }
}
