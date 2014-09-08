package com.pahanez.familytask.loader;

import android.content.Context;
import android.util.Log;

import com.github.kevinsawicki.wishlist.AsyncLoader;
import com.pahanez.familytask.Application;
import com.pahanez.familytask.activity.ActivityInteractor;

import java.lang.ref.WeakReference;

public abstract class FamilyLoader<T> extends AsyncLoader<T> {

    private WeakReference<CounterInteractor> mInteractor;

    public FamilyLoader(CounterInteractor interactor ){
        super(Application.getContext());
        mInteractor = new WeakReference<CounterInteractor>(interactor);
    }


    @Override
    protected void onStartLoading() {
        super.onStartLoading();
        mInteractor.get().startProgress();
        Log.e("p37td8" , "onStartLoading");
    }

    @Override
    protected void onStopLoading() {
        super.onStopLoading();
        mInteractor.get().stopProgress();
        Log.e("p37td8" , "onStopLoading");
    }


}
