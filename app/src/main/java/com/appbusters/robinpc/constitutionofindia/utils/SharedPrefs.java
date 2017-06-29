package com.appbusters.robinpc.constitutionofindia.utils;

import android.content.Context;
import android.content.SharedPreferences;
import com.appbusters.robinpc.constitutionofindia.ConstitutionApp;

public class SharedPrefs {

    private static final String DETAIL_TEXT_SIZE = "detail_text_size";

    private static SharedPreferences getPreferences(){
        Context context = ConstitutionApp.getAppContext();
        return  context.getSharedPreferences(context.getPackageName(), Context.MODE_PRIVATE);
    }

    /*....................................................................................*/

    public static void setDetailTextSize(int token){
        SharedPreferences.Editor editor = getPreferences().edit();
        editor.putInt(DETAIL_TEXT_SIZE, token);
        editor.apply();
    }

    public static int getDetailTextSize() {
        return SharedPrefs.getPreferences().getInt(DETAIL_TEXT_SIZE, 15);
    }

}
