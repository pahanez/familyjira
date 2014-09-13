package com.pahanez.familytask.loader;

import android.os.AsyncTask;

/**
 * Created by pindziukou on 08.09.14.
 */
public abstract class FamilyAsyncTask<V,T,B> extends AsyncTask<V,T,B>{

    private LoadCounter mLoadCounter;

    public FamilyAsyncTask(LoadCounter loadCounter){
        this.mLoadCounter = loadCounter;
    }

    @Override
    protected void onPreExecute() {
        mLoadCounter.startProgress();
        super.onPreExecute();
    }

    @Override
    protected void onPostExecute(B b) {
        super.onPostExecute(b);
        mLoadCounter.stopProgress();
    }


    @Override
    protected void onCancelled() {
        super.onCancelled();
        mLoadCounter.stopProgress();
    }
}
