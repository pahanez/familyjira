package com.pahanez.familytask.activity;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;

import com.pahanez.familytask.R;
import com.pahanez.familytask.activity.module.AppActivityModule;
import com.pahanez.familytask.activity.presenter.AppPresenter;
import com.pahanez.familytask.activity.presenter.AppPresenterImpl;
import com.pahanez.familytask.activity.view.AppView;
import com.pahanez.familytask.workers.AppActivityWorkerImpl;
import com.squareup.otto.Bus;

import java.util.Arrays;
import java.util.List;

import javax.inject.Inject;

/**
 * Created by pindziukou on 15.09.14.
 */
public class AppActivity extends BaseActivity implements AppView{

    @Inject
    AppPresenter mPresenter;

    @Inject
    Bus mBus;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.base_l);

    }

    @Override
    protected void onResume() {
        super.onResume();
        mPresenter.prepareActionBar();
    }

    @Override
    protected List<Object> getModules() {
        return Arrays.<Object>asList(new AppActivityModule(this));
    }

    @Override
    public void setActionTitle() {
        // call from presenter
    }

    @Override
    public void prepareActionBar() {
        getActionBar().setTitle("AppActivity");
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.family_main,menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int itemId = item.getItemId();
        switch (itemId){
            case R.id.action_ref:
                mPresenter.updateData();
                break;
        }
        return super.onOptionsItemSelected(item);
    }
}
