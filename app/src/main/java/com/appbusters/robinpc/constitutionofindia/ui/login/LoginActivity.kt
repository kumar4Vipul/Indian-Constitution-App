package com.appbusters.robinpc.constitutionofindia.ui.login

import android.content.Context
import android.content.Intent
import com.appbusters.robinpc.constitutionofindia.R
import com.appbusters.robinpc.constitutionofindia.ui.base.BaseActivity

class LoginActivity : BaseActivity() {

    override fun getLayoutResId(): Int {
        return R.layout.activity_login
    }

    override fun setup() {
    }

    companion object {
        fun newIntent(context: Context): Intent {
            return Intent(context, LoginActivity::class.java)
        }
    }
}
