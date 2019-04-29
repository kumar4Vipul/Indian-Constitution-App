package com.appbusters.robinpc.constitutionofindia.ui.splash

import android.os.Handler
import com.appbusters.robinpc.constitutionofindia.R
import com.appbusters.robinpc.constitutionofindia.ui.base.BaseActivity
import com.appbusters.robinpc.constitutionofindia.ui.login.LoginActivity


class SplashActivity : BaseActivity() {

    companion object {
        const val SPLASH_TIMEOUT = 1000L
    }

    override fun getLayoutResId(): Int {
        return R.layout.activity_splash
    }

    override fun setup() {
        setStatusBarColor(R.color.black)
        launchNewsListActivity()
    }

    private fun launchNewsListActivity() {
        Handler().postDelayed({
            startActivity(LoginActivity.newIntent(this))
            animateActivityTransition(R.anim.slide_in_right, R.anim.slide_out_left)
            finishAffinity()
        }, SPLASH_TIMEOUT)
    }

    protected fun animateActivityTransition(enterAnim: Int, exitAnim: Int) {
        overridePendingTransition(enterAnim, exitAnim)
    }
}
