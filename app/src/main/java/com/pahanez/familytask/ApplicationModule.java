package com.pahanez.familytask;

import android.content.Context;

import com.pahanez.familytask.activity.presenter.MainPresenter;
import com.pahanez.familytask.workers.WorkersModule;
import com.squareup.otto.Bus;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

@Module(
        library = true
)
public class ApplicationModule {
    private Application mApplication;

    public ApplicationModule(Application application){
        this.mApplication = application;
    }

    @Provides @Singleton Application provideApplication() {
        return mApplication;
    }

    @Provides @Singleton Context provideContext() { return mApplication; }

    @Provides @Singleton Bus provideBus() {
        return new Bus();
    }
}
