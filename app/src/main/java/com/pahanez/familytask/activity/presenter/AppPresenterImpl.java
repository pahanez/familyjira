package com.pahanez.familytask.activity.presenter;

import com.pahanez.familytask.Application;
import com.pahanez.familytask.activity.view.AppView;
import com.pahanez.familytask.workers.AppActivityWorker;
import com.squareup.otto.Bus;

/**
 * Created by pindziukou on 15.09.14.
 */
public class AppPresenterImpl implements AppPresenter{
    private AppView mAppView;
    private Application mApp;
    private AppActivityWorker mWorker;

    public AppPresenterImpl(AppView appView,Application app,AppActivityWorker worker){
        this.mAppView = appView;
        this.mApp = app;
        this.mWorker = worker;
    }


    @Override
    public void prepareActionBar() {
        mAppView.prepareActionBar();
    }

    @Override
    public void updateData() {
        android.util.Log.e("p37td8","bus : " + mWorker);
        mWorker.ref();
    }
}
