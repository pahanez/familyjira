package com.pahanez.familytask;

import android.content.Context;

import com.pahanez.familytask.model.Mock;

import java.util.Arrays;
import java.util.List;

import dagger.ObjectGraph;

public class Application extends android.app.Application{

    private ObjectGraph mObjectGraph;
    private Object modules;

    @Override
    public void onCreate() {
        super.onCreate();
        mObjectGraph = ObjectGraph.create(getModules().toArray());
    }

    public List<Object> getModules() {
        return Arrays.<Object>asList(new ApplicationModule(this) , new Mock());
    }

    public void inject(Object object){
        mObjectGraph.inject(object);
    }
}
