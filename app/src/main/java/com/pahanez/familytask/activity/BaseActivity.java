package com.pahanez.familytask.activity;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.util.AttributeSet;
import android.view.View;

import com.pahanez.familytask.Application;
import com.pahanez.familytask.activity.view.Injector;

import java.util.Collections;
import java.util.List;

import dagger.ObjectGraph;

public abstract class BaseActivity extends Activity implements Injector{

    private ObjectGraph mActivityGraph;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mActivityGraph = ((Application)getApplication()).createScopedGraph(getModules().toArray());
        mActivityGraph.inject(this);

        Object presenter = createPresenter();
//        ((Application)getApplication()).inject(presenter);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        mActivityGraph = null;
    }

    protected <T> T getView(int id) {
        return (T) findViewById(id);
    }

    @Override
    public void inject(Object object) {
        mActivityGraph.inject(object);
    }

    protected abstract Object createPresenter();

    protected List<Object> getModules(){
        return Collections.emptyList();
    }
}
