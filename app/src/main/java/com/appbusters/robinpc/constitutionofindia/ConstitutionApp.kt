package com.appbusters.robinpc.constitutionofindia

import android.app.Activity
import android.app.Application
import android.content.Context
import com.appbusters.robinpc.constitutionofindia.di.component.ConstitutionAppComponent
import com.appbusters.robinpc.constitutionofindia.di.component.DaggerConstitutionAppComponent
import com.appbusters.robinpc.constitutionofindia.di.module.ContextModule

import io.github.inflationx.calligraphy3.CalligraphyConfig
import io.github.inflationx.calligraphy3.CalligraphyInterceptor
import io.github.inflationx.viewpump.ViewPump

class ConstitutionApp : Application() {

    private lateinit var component: ConstitutionAppComponent

    override fun onCreate() {
        super.onCreate()

        ViewPump.init(ViewPump.builder()
                .addInterceptor(CalligraphyInterceptor(
                        CalligraphyConfig.Builder()
                                .setDefaultFontPath("fonts/splash_english_simple.ttf")
                                .setFontAttrId(R.attr.fontPath)
                                .build())).build())

        component = DaggerConstitutionAppComponent.builder()
                .contextModule(ContextModule(this))
                .build()
    }

    fun constitutionAppComponent(): ConstitutionAppComponent {
        return component
    }

    companion object {
        fun get(activity: Activity): ConstitutionApp {
            return activity.application as ConstitutionApp
        }
    }
}
