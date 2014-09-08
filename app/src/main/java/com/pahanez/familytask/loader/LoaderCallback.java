package com.pahanez.familytask.loader;

import android.app.LoaderManager;
import android.content.Loader;
import android.os.Bundle;

import java.lang.ref.WeakReference;

public class LoaderCallback implements LoaderManager.LoaderCallbacks{

    private WeakReference<CounterInteractor> mInteractor;
    private Loader mLoader;

    public LoaderCallback(CounterInteractor activity , Loader loader){
        this.mInteractor = new WeakReference<CounterInteractor>(activity);
        this.mLoader = loader;
    }

    @Override
    public Loader onCreateLoader(int id, Bundle args) {
        return mLoader;
    }

    @Override
    public void onLoadFinished(Loader loader, Object data) {
        this.mInteractor.get().stopProgress();
//        this.mInteractor.get().loaderResult(data);

    }

    @Override
    public void onLoaderReset(Loader loader) {
        this.mInteractor.get().stopProgress();
    }

}
