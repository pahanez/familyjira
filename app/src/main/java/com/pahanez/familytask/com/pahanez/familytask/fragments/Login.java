package com.pahanez.familytask.com.pahanez.familytask.fragments;



import android.os.Bundle;
import android.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.pahanez.familytask.R;

/**
 * A simple {@link Fragment} subclass.
 *
 */
public class Login extends Parent {
    @Override
    protected String getActionBarTitle() {
        return getString(R.string.login);
    }

    public static Login newInstance() {
        Login fragment = new Login();
        return fragment;
    }

    public Login() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_login, container, false);
    }


}
