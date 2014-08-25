package com.pahanez.familytask;

import android.content.Context;

public class Application extends android.app.Application{

    private static Context mContext;
    @Override
    public void onCreate() {
        super.onCreate();
        mContext = getApplicationContext();
    }

    public static Context getContext(){
        return mContext;
    }
}
