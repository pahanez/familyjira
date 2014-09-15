package com.pahanez.familytask.activity.presenter;

import android.content.Context;

import com.pahanez.familytask.Application;
import com.pahanez.familytask.activity.view.AppView;

/**
 * Created by pindziukou on 15.09.14.
 */
public class AppPresenterImpl implements AppPresenter{
    private AppView mAppView;
    private Application mApp;

    public AppPresenterImpl(AppView appView,Application app){
        this.mAppView = appView;
        this.mApp = app;
    }


}
