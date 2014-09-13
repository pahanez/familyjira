package com.pahanez.familytask;

import android.app.Activity;
import android.app.Fragment;
import android.app.FragmentTransaction;
import android.app.LoaderManager;
import android.content.Loader;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.view.animation.AnimationUtils;

import com.github.kevinsawicki.wishlist.ViewFinder;
import com.github.kevinsawicki.wishlist.ViewUtils;
import com.pahanez.familytask.activity.ActivityInteractor;
import com.pahanez.familytask.activity.presenter.MainPresenter;
import com.pahanez.familytask.activity.view.MainView;
import com.pahanez.familytask.com.pahanez.familytask.fragments.Login;
import com.pahanez.familytask.com.pahanez.familytask.fragments.Register;
import com.pahanez.familytask.loader.FamilyLoader;
import com.pahanez.familytask.loader.LoaderCallback;
import com.pahanez.familytask.loader.MockLoader;
import com.pahanez.familytask.model.Mock;

import java.util.Date;

import javax.inject.Inject;


public class FamilyMain extends Activity implements ActivityInteractor , MainView{

    private View mProgress;
    private ViewFinder mFind;
    private MainPresenter mMainPresenter;

    @Inject Mock mock;
    @Inject Application mApp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_family_main);
        mFind = new ViewFinder(this);
        findViews();

        ((Application)getApplication()).inject(this);

        mMainPresenter = new MainPresenter(this);
        android.util.Log.e("p37td8" , "app : " +mApp);

//        ((Application)getApplication()).inject(mMainPresenter);

//        mMainPresenter.loadData(getLoaderManager());

    }

    private void findViews() {
        mProgress = mFind.find(R.id.progressView);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    private void initFragment(Fragment fragment , boolean backstack) {
        FragmentTransaction ft = getFragmentManager().beginTransaction();
        ft.replace(R.id.act_container, fragment);

        if(backstack)
            ft.addToBackStack(null);

        ft.commit();
    }



    private void initFragment(Fragment fragment){
        initFragment(fragment, false);
    }

    @Override
    public void onViewClicked(int id) {
        switch (id){
            case R.id.signin:
                    initFragment(Login.newInstance(),true);
                break;
            case R.id.signup:
                    initFragment(Register.newInstance(),true);
                break;
            case R.id.reg_register:
                    android.util.Log.e("p37td8" , "reg reg");
                break;
        }
    }

    @Override
    public <V> void loaderResult(V result) {
        ((Application)getApplication()).inject(this);

    }

    private FamilyMain fadeIn(final View view) {
           view.startAnimation(AnimationUtils.loadAnimation(this, android.R.anim.fade_in));
        return this;
    }

    private FamilyMain fadeOut(final View view) {
            view.startAnimation(AnimationUtils.loadAnimation(this, android.R.anim.fade_out));
        return this;
    }

    private FamilyMain show(final View view) {
        ViewUtils.setGone(view, false);
        return this;
    }

    private FamilyMain hide(final View view) {
        ViewUtils.setGone(view, true);
        return this;
    }

    @Override
    public void showProgress() {
        fadeIn(mProgress).show(mProgress);
    }

    @Override
    public void hideProgress() {
        hide(mProgress).fadeOut(mProgress);
    }
}
