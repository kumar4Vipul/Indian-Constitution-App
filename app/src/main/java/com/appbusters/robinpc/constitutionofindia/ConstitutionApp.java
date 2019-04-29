package com.appbusters.robinpc.constitutionofindia;

import android.app.Application;
import android.content.Context;

public class ConstitutionApp extends Application{

    private static Context context;

    @Override
    public void onCreate() {
        context = getApplicationContext();
        super.onCreate();
    }

    public static Context getAppContext() {
        return context;
    }
}
