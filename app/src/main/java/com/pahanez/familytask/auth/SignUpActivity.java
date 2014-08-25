package com.pahanez.familytask.auth;

import android.accounts.AccountManager;
import android.app.Activity;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.iangclifton.android.floatlabel.FloatLabel;
import com.pahanez.familytask.R;
import static com.pahanez.familytask.auth.AccountGeneral.*;
import static com.pahanez.familytask.auth.AuthenticatorActivity.*;


public class SignUpActivity extends Activity {

    private String TAG = getClass().getSimpleName();
    private String mAccountType;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        mAccountType = getIntent().getStringExtra(ARG_ACCOUNT_TYPE);

        setContentView(R.layout.fragment_register);

        /*findViewById(R.id.alreadyMember).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setResult(RESULT_CANCELED);
                finish();
            }
        });*/ //TODO
        findViewById(R.id.reg_register).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                createAccount();
            }
        });
    }

    private void createAccount() {

        //TODO Validation!

        new AsyncTask<String, Void, Intent>() {

            String name = ((FloatLabel) findViewById(R.id.reg_username)).getEditText().getText().toString().trim();
            String accountName = ((FloatLabel) findViewById(R.id.reg_email)).getEditText().getText().toString().trim();
            String accountPassword = ((FloatLabel) findViewById(R.id.reg_pass)).getEditText().getText().toString().trim();

            @Override
            protected Intent doInBackground(String... params) {

                String authtoken = null;
                Bundle data = new Bundle();
                try {
                    authtoken = sServerAuthenticate.userSignUp(name, accountName, accountPassword, AccountGeneral.AUTHTOKEN_TYPE_FULL_ACCESS);

                    data.putString(AccountManager.KEY_ACCOUNT_NAME, accountName);
                    data.putString(AccountManager.KEY_ACCOUNT_TYPE, mAccountType);
                    data.putString(AccountManager.KEY_AUTHTOKEN, authtoken);
                    data.putString(PARAM_USER_PASS, accountPassword);
                } catch (Exception e) {
                    data.putString(KEY_ERROR_MESSAGE, e.getMessage());
                }

                final Intent res = new Intent();
                res.putExtras(data);
                return res;
            }

            @Override
            protected void onPostExecute(Intent intent) {
                if (intent.hasExtra(KEY_ERROR_MESSAGE)) {
                    Toast.makeText(getBaseContext(), intent.getStringExtra(KEY_ERROR_MESSAGE), Toast.LENGTH_SHORT).show();
                } else {
                    setResult(RESULT_OK, intent);
                    finish();
                }
            }
        }.execute();
    }

    @Override
    public void onBackPressed() {
        setResult(RESULT_CANCELED);
        super.onBackPressed();
    }
}
