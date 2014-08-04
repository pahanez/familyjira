package com.pahanez.familytask.com.pahanez.familytask.fragments;



import android.app.Activity;
import android.os.Bundle;
import android.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.pahanez.familytask.R;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link Register#newInstance} factory method to
 * create an instance of this fragment.
 *
 */
public class Register extends Parent {

    private FragmentInteractionListener mListener;

    public static Register newInstance() {
        Register fragment = new Register();
        return fragment;
    }
    public Register() {
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_register, container, false);
    }

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        try {
            mListener = (FragmentInteractionListener) activity;
        } catch (ClassCastException e) {
            throw new ClassCastException(activity.toString()
                    + " must implement FragmentInteractionListener");
        }
    }


    @Override
    protected String getActionBarTitle() {
        return getString(R.string.register);
    }
}
