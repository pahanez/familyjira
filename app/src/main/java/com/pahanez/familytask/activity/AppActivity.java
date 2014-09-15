package com.pahanez.familytask.activity;

import android.os.Bundle;

import com.pahanez.familytask.R;
import com.pahanez.familytask.activity.module.AppActivityModule;
import com.pahanez.familytask.activity.presenter.AppPresenter;
import com.pahanez.familytask.activity.presenter.AppPresenterImpl;
import com.pahanez.familytask.activity.view.AppView;

import java.util.Arrays;
import java.util.List;

import javax.inject.Inject;

/**
 * Created by pindziukou on 15.09.14.
 */
public class AppActivity extends BaseActivity implements AppView{

    @Inject
    AppPresenter mPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.base_l);

    }

    @Override
    protected Object createPresenter() {
        return mPresenter;
    }

    @Override
    protected List<Object> getModules() {
        return Arrays.<Object>asList(new AppActivityModule(this));
    }

    @Override
    public void setActionTitle() {
        // call from presenter
    }
}
