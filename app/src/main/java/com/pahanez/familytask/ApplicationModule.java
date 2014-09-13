package com.pahanez.familytask;

import com.pahanez.familytask.activity.presenter.MainPresenter;

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

    @Provides public Application provideApplication() {
        return mApplication;
    }
}