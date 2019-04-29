package com.appbusters.robinpc.constitutionofindia.ui.base

import android.content.pm.ActivityInfo
import android.os.Bundle
import androidx.core.content.ContextCompat
import android.view.WindowManager
import androidx.appcompat.app.AppCompatActivity

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
    }
}