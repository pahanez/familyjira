package com.pahanez.familytask.com.pahanez.familytask.fragments;



import android.app.Activity;
import android.os.Bundle;
import android.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.pahanez.familytask.R;
import com.parse.LogInCallback;
import com.parse.ParseException;
import com.parse.ParseUser;

/**
 * A simple {@link Fragment} subclass.
 *
 */
public class Login extends Parent {

    private Button mLogin;
    private FragmentInteractionListener mListener;

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
        return inflater.inflate(R.layout.fragment_login, container, false);
    }

    @Override
    protected void findViews() {
        mLogin = mFind.find(R.id.log_login);
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
    protected void initViews() {
        mLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mListener.startProgress();
                ParseUser.logInInBackground("p37td7", "kodobase", new LogInCallback() {
                    @Override
                    public void done(ParseUser parseUser, ParseException e) {
                        if (null == e) {
                            Log.e("p37td8", "" + parseUser.getEmail() + " username " + parseUser.getUsername() + "  pass " + parseUser.getSessionToken());
                        } else {
                            Log.e("p37td8", "bad login == " + e);
                        }
                        mListener.stopProgress();
                    }
                });
            }
        });
    }

}
