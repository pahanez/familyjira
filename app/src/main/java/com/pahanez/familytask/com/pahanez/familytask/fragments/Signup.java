package com.pahanez.familytask.com.pahanez.familytask.fragments;

import android.app.Activity;
import android.os.Bundle;
import android.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.pahanez.familytask.R;
import com.romainpiel.shimmer.Shimmer;
import com.romainpiel.shimmer.ShimmerTextView;

/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link com.pahanez.familytask.com.pahanez.familytask.fragments.Signup.FragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link Signup#newInstance} factory method to
 * create an instance of this fragment.
 *
 */
public class Signup extends Fragment implements View.OnClickListener {

    private ShimmerTextView mShimmer;
    private Button mRegister,mLogin;


    private FragmentInteractionListener mListener;

    // TODO: Rename and change types and number of parameters
    public static Signup newInstance() {
        Signup fragment = new Signup();
        return fragment;
    }
    public Signup() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_signup, container, false);
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        mShimmer = (ShimmerTextView) view.findViewById(R.id.shimmer_title);

        mRegister = (Button) view.findViewById(R.id.signup);
        mLogin = (Button) view.findViewById(R.id.signin);
        mRegister.setOnClickListener(this);
        mLogin.setOnClickListener(this);

    }

    @Override
    public void onResume() {
        super.onResume();
        Shimmer shimmer = new Shimmer();
        shimmer.setStartDelay(3000);
        shimmer.start(mShimmer);
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
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

    @Override
    public void onClick(View v) {
        onButtonPressed(v.getId());
    }


}
