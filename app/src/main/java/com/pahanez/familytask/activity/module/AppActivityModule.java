package com.pahanez.familytask.activity.module;

import android.content.Context;

import com.pahanez.familytask.Application;
import com.pahanez.familytask.ApplicationModule;
import com.pahanez.familytask.activity.AppActivity;
import com.pahanez.familytask.activity.interactors.AppActivityInteractor;
import com.pahanez.familytask.activity.presenter.AppPresenter;
import com.pahanez.familytask.activity.presenter.AppPresenterImpl;
import com.pahanez.familytask.activity.view.AppView;
import com.pahanez.familytask.workers.AppActivityWorker;
import com.pahanez.familytask.workers.WorkersModule;
import com.squareup.otto.Bus;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * Created by pindziukou on 15.09.14.
 */
@Module(injects = {AppActivity.class}, addsTo = ApplicationModule.class , includes = WorkersModule.class)
public class AppActivityModule {

    private AppView mAppView;

    public AppActivityModule(AppView appView){
        this.mAppView = appView;
    }

    @Provides @Singleton public AppView providesView(){
        return mAppView;
    }

    @Provides @Singleton public AppPresenter providePresenter(AppView appView, Application app, AppActivityWorker worker ){
        return  new AppPresenterImpl(appView, app, worker);

    }

}
