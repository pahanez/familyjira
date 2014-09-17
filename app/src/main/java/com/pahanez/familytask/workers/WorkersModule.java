package com.pahanez.familytask.workers;

import dagger.Module;
import dagger.Provides;

/**
 * Created by pindziukou on 15.09.14.
 */
@Module(library = true)
public class WorkersModule {
    @Provides public AppActivityWorker provideAppActivityWorker(){
        return new AppActivityWorkerImpl();
    }
}
