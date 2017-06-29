package com.appbusters.robinpc.constitutionofindia;

import android.app.Application;
import android.content.Context;

public class ConstitutionApp extends Application{

    private static Context sContext;

    @Override
    public void onCreate() {
        sContext = getApplicationContext();
        super.onCreate();
    }

    public static Context getAppContext() {
        return sContext;
    }
}
