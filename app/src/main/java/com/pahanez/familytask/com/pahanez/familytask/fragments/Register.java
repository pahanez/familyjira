package com.pahanez.familytask.com.pahanez.familytask.fragments;



import android.app.Activity;
import android.os.Bundle;
import android.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import com.iangclifton.android.floatlabel.FloatLabel;
import com.pahanez.familytask.R;
import com.parse.ParseException;
import com.parse.ParseUser;
import com.parse.SignUpCallback;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link Register#newInstance} factory method to
 * create an instance of this fragment.
 *
 */
public class Register extends Parent {

    private FragmentInteractionListener mListener;
    private Button mButton;
    private FloatLabel mUsernameET;
    private FloatLabel mPassET;
    private FloatLabel mEmailET;
    private FloatLabel mConfpassET;

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
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        findViews();
        initViews();
    }


    protected void findViews() {
        mButton = mFind.find(R.id.reg_register);
        mUsernameET = mFind.find(R.id.reg_username);
        mPassET = mFind.find(R.id.reg_pass);
        mConfpassET = mFind.find(R.id.reg_confpass);
        mEmailET = mFind.find(R.id.reg_email);
    }
    protected void initViews() {
        mButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ParseUser user = new ParseUser();
                //TODO
                user.setUsername("p37td7");
                user.setPassword("kodobase");
                user.setEmail("costom@comt.com");

                user.signUpInBackground( new SignUpCallback() {
                    @Override
                    public void done(ParseException e) {
                        if(null == e){
                            android.util.Log.e("p37td8" , "nice");
                        }else{
                            android.util.Log.e("p37td8" , "bad : " + e);

                        }
                    }

                });
//                onButtonPressed(v.getId());
            }
        });
    }

    public void onButtonPressed(int id) {
        if (mListener != null) {
            mListener.onViewClicked(id);
        }
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
