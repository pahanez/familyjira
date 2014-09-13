package com.pahanez.familytask.model;

import com.pahanez.familytask.FamilyMain;

import javax.inject.Inject;

import dagger.Module;
import dagger.Provides;

@Module( complete = false, injects = FamilyMain.class)
public class Mock {

    @Inject
    public Mock(){

    }
}
