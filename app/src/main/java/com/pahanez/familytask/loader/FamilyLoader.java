package com.pahanez.familytask.loader;

import android.content.Context;
import android.util.Log;

import com.github.kevinsawicki.wishlist.AsyncLoader;
import com.pahanez.familytask.Application;
import com.pahanez.familytask.activity.ActivityInteractor;

import java.lang.ref.WeakReference;

import javax.inject.Inject;

public abstract class FamilyLoader<T> extends AsyncLoader<T> {

    private WeakReference<CounterInteractor> mInteractor;

    public FamilyLoader(Context context ,CounterInteractor interactor ){
        super(context);
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
