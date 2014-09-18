package com.pahanez.familytask.workers;

import com.pahanez.familytask.utils.DataProvider;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import retrofit.RestAdapter;

/**
 * Created by pindziukou on 15.09.14.
 */
@Module(library = true , complete = false)
public class WorkersModule {

    @Provides @Singleton
    ParseService provideParseRestService(){
        RestAdapter restAdapter = new RestAdapter.Builder()
                .setEndpoint("https://api.github.com")
                .build();
        ParseService service = restAdapter.create(ParseService.class);
        return service;
    }

    @Provides TaskWorker provideNetworkTaskWorker(ParseService parseService){
        return new NetworkTaskWorker(parseService);
    }

    @Provides public AppActivityWorker provideAppActivityWorker(TaskWorker taskWorker ){
        return new AppActivityWorkerImpl(taskWorker);
    }
}
