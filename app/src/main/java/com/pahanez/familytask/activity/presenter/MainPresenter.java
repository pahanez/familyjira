package com.pahanez.familytask.activity.presenter;

import android.app.LoaderManager;
import android.content.Context;
import android.content.Loader;

import com.pahanez.familytask.Application;
import com.pahanez.familytask.activity.view.MainView;
import com.pahanez.familytask.loader.CounterInteractor;
import com.pahanez.familytask.loader.LoadCounter;
import com.pahanez.familytask.loader.LoaderCallback;
import com.pahanez.familytask.loader.MockLoader;

import java.lang.ref.WeakReference;

import javax.inject.Inject;

/**
 * Created by pindziukou on 08.09.14.
 */
public class MainPresenter implements CounterInteractor {

    public static int MAIN_LOADER_ID = 100;

    @Inject
    Application mApplication;
    private MainView mMainView;
    private LoadCounter mLoadCounter = new LoadCounter(this);

    public MainPresenter(MainView mainView){
        this.mMainView = mainView;

    }

    @Override
    public void startProgress() {
        mMainView.showProgress();
    }

    @Override
    public void stopProgress() {
        mMainView.hideProgress();

    }

    public void loadData(LoaderManager loaderManager) {
        android.util.Log.e("p37td8" , "app : " + mApplication);
        Loader loader = new MockLoader(mApplication ,mLoadCounter);
        LoaderCallback callback = new LoaderCallback(mLoadCounter , loader);
        loaderManager.initLoader(MAIN_LOADER_ID , null , callback);

    }
}
