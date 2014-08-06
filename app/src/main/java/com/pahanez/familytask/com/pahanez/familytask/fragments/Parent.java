package com.pahanez.familytask.com.pahanez.familytask.fragments;

import android.app.ActionBar;
import android.app.Fragment;
import android.os.Bundle;
import android.view.View;

import com.github.kevinsawicki.wishlist.ViewFinder;

abstract class Parent extends Fragment{

    protected ViewFinder mFind;

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        mFind = new ViewFinder(view);
        setActionBarTitle();
    }

    protected void setActionBarTitle(){
        String title = getActionBarTitle();

        ActionBar actionbar = getActivity().getActionBar();
        actionbar.setTitle(title);
    }


    protected abstract String getActionBarTitle();

}
