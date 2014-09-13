package com.pahanez.familytask.loader;

import android.content.Context;

import com.pahanez.familytask.activity.ActivityInteractor;

import java.util.concurrent.TimeUnit;

public class MockLoader extends FamilyLoader<String>{
    public MockLoader(Context context , CounterInteractor interactor) {
        super(context, interactor);
    }

    @Override
    public String loadInBackground() {
            try {
                TimeUnit.SECONDS.sleep(5);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            return "gotcha";
        }

}
