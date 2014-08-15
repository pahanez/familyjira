package com.pahanez.familytask;

import android.accounts.Account;
import android.accounts.AccountManager;
import android.accounts.AccountManagerCallback;
import android.accounts.AccountManagerFuture;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

import com.pahanez.familytask.R;
import com.pahanez.familytask.auth.AccountGeneral;
import com.pahanez.familytask.auth.AuthenticatorActivity;
import com.pahanez.familytask.auth.SignUpActivity;

public class LoginActivity extends Activity {

    private static final String TAG = LoginActivity.class.getSimpleName();

    private Button mSignIn;
    private AccountManager mAccountManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        mAccountManager = AccountManager.get(this);
        findViews();
        initViews();
    }


    private void findViews() {
        mSignIn = (Button) findViewById(R.id.signin);
    }

    private void initViews() {
        mSignIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final AccountManagerFuture<Bundle> future = mAccountManager.addAccount(AccountGeneral.ACCOUNT_TYPE, AccountGeneral.AUTHTOKEN_TYPE_FULL_ACCESS, null, null, LoginActivity.this, new AccountManagerCallback<Bundle>() {
                    @Override
                    public void run(AccountManagerFuture<Bundle> future) {
                        try {
                            Bundle bnd = future.getResult();
                            Log.e("p37td8", "AddNewAccount Bundle is " + bnd);

                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    }
                }, null);
            }
        });

    }



}
