package com.appbusters.robinpc.constitutionofindia.ui.home

import android.content.Context
import android.content.Intent
import com.appbusters.robinpc.constitutionofindia.R
import com.appbusters.robinpc.constitutionofindia.ui.base.BaseActivity
import com.appbusters.robinpc.constitutionofindia.ui.home.home_fragment.HomeFragment

class HomeActivity : BaseActivity() {

    override fun getLayoutResId(): Int {
        return R.layout.activity_home
    }

    override fun setup() {
        setStatusBarColor(R.color.home_status_bar)
        setHomeFragment()
    }

    private fun setHomeFragment() {
        supportFragmentManager.beginTransaction().replace(R.id.fragmentContainer, HomeFragment.newInstance()).commit()
    }

    companion object {
        fun newIntent(context: Context): Intent {
            return Intent(context, HomeActivity::class.java)
        }
    }
}
