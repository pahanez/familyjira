package com.pahanez.familytask.loader;

import java.util.concurrent.atomic.AtomicInteger;

public class LoadCounter implements CounterInteractor{

    private CounterInteractor mCounterInteractor;
    private AtomicInteger mCount = new AtomicInteger();

    public LoadCounter(CounterInteractor counterInteractor){
        this.mCounterInteractor = counterInteractor;
    }

    public void startProgress(){
        int counter = mCount.getAndIncrement();
        if(counter == 0)
            mCounterInteractor.startProgress();
    }

    public void stopProgress(){
        int counter = mCount.decrementAndGet();
        if(counter == 0)
            mCounterInteractor.stopProgress();
    }
}
