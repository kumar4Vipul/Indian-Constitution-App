@file:Suppress("unused")

package com.appbusters.robinpc.constitutionofindia.ui.base

import android.app.Activity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.appbusters.robinpc.constitutionofindia.ConstitutionApp
import com.appbusters.robinpc.constitutionofindia.di.component.ConstitutionAppComponent

abstract class BaseFragment: Fragment() {

    private lateinit var parent: View

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        parent = inflater.inflate(getLayoutResId(), container, false)
        return parent
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setup()
    }

    protected fun animateActivityTransition(enterAnim: Int, exitAnim: Int) {
        context?.let {
            (it as Activity).overridePendingTransition(enterAnim, exitAnim)
        }
    }

    protected fun getAppComponent(activity: Activity): ConstitutionAppComponent {
        return ConstitutionApp.get(activity).constitutionAppComponent()
    }

    abstract fun getLayoutResId(): Int

    abstract fun setup()

    fun getParentView(): View {
        return parent
    }
}