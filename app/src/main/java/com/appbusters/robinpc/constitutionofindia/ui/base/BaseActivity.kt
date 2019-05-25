package com.appbusters.robinpc.constitutionofindia.ui.base

import android.content.Context
import android.content.pm.ActivityInfo
import android.os.Bundle
import android.view.View
import androidx.core.content.ContextCompat
import android.view.WindowManager
import androidx.appcompat.app.AppCompatActivity
import io.github.inflationx.viewpump.ViewPumpContextWrapper

abstract class BaseActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(getLayoutResId())

        requestedOrientation = ActivityInfo.SCREEN_ORIENTATION_PORTRAIT

        setup()
    }

    abstract fun getLayoutResId(): Int

    abstract fun setup()

    protected fun setStatusBarColor(color: Int) {
        window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS)
        window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS)
        window.statusBarColor = ContextCompat.getColor(this, color)

        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.M)
            window.decorView.systemUiVisibility = View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR
    }

    protected fun animateActivityTransition(enterAnim: Int, exitAnim: Int) {
        overridePendingTransition(enterAnim, exitAnim)
    }

    override fun attachBaseContext(newBase: Context) {
        super.attachBaseContext(ViewPumpContextWrapper.wrap(newBase))
    }
}