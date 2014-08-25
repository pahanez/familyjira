package com.pahanez.familytask;

import android.accounts.Account;
import android.accounts.AccountManager;
import android.accounts.AccountManagerCallback;
import android.accounts.AccountManagerFuture;
import android.animation.Animator;
import android.app.Activity;
import android.content.Intent;
import android.graphics.PorterDuff;
import android.os.Bundle;
import android.os.Handler;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.github.kevinsawicki.wishlist.TypefaceUtils;
import com.github.kevinsawicki.wishlist.ViewFinder;
import com.github.kevinsawicki.wishlist.ViewUtils;
import com.pahanez.familytask.auth.AccountGeneral;
import com.pahanez.familytask.utils.AnimUtils;
import com.romainpiel.shimmer.Shimmer;
import com.romainpiel.shimmer.ShimmerTextView;

public class LoginActivity extends Activity {

    private static final String TAG = LoginActivity.class.getSimpleName();
    private static final int ANIMATION_DURATION = 5000;

    private Button mSignIn;
    private AccountManager mAccountManager;
    private ImageView mBGimg;
    private TextView mTitle, mTitleHead;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        mAccountManager = AccountManager.get(this);
        getActionBar().hide();
        findViews();
        initViews();
        checkCurrentAccount();

        //TODO if should
        startAnimations();
    }


    private void findViews() {
        ViewFinder finder = new ViewFinder(this);
        mSignIn = finder.find(R.id.signin);
        mBGimg = finder.find(R.id.bgimg);
        mTitle = finder.find(R.id.shimmer_title);
        mTitleHead = finder.find(R.id.shimmer_title_head);
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
                            checkCurrentAccount();
                            Log.e("p37td8", "AddNewAccount Bundle is " + bnd);

                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    }
                }, null);
            }
        });

        mBGimg.getDrawable().setColorFilter(getResources().getColor(R.color.bad_purple), PorterDuff.Mode.MULTIPLY);
        mTitle.setTypeface(TypefaceUtils.getTypeface(getString(R.string.font), this));
        mTitleHead.setTypeface(TypefaceUtils.getTypeface(getString(R.string.font), this));
    }

    private void startAnimations() {
        mBGimg.startAnimation(AnimationUtils.loadAnimation(this, R.anim.infinite_rorate_scale));

        final Shimmer shimmer = new Shimmer();
        shimmer.setDuration(1000);
        shimmer.start((ShimmerTextView) mTitle);


        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {

                mBGimg.animate().setDuration(1000).setListener(new Animator.AnimatorListener() {
                    @Override
                    public void onAnimationStart(Animator animation) {

                    }

                    @Override
                    public void onAnimationEnd(Animator animation) {
                        ViewUtils.setGone(mBGimg, true);
                        shimmer.cancel();
                        mTitle.startAnimation(AnimUtils.verticalOutBottom(new AnimUtils.AnimationListenerImpl() {
                            @Override
                            public void onAnimationEnd(Animation animation) {
                                ViewUtils.setGone(mTitle, true);
                            }

                        }));

                        mTitleHead.startAnimation(AnimUtils.verticalInTopScale(new AnimUtils.AnimationListenerImpl() {
                            @Override
                            public void onAnimationStart(Animation animation) {
                                ViewUtils.setGone(mTitleHead, false);
                            }

                            @Override
                            public void onAnimationEnd(Animation animation) {
                                prepareLayoutAfterAnimation();
                            }

                            private void prepareLayoutAfterAnimation() {
                                showButton();
                                mBGimg.clearAnimation();
                                mBGimg.setScaleX(2.2F);
                                mBGimg.setScaleY(2.2F);
                                mBGimg.setAlpha(1.0F);

                                show(mBGimg);
                            }
                        }));
                    }

                    @Override
                    public void onAnimationCancel(Animator animation) {

                    }

                    @Override
                    public void onAnimationRepeat(Animator animation) {

                    }
                }).alpha(0);
            }
        }, ANIMATION_DURATION);

    }

    public void showButton() {
        fadeIn(mSignIn).show(mSignIn);
    }

    private LoginActivity fadeIn(final View view) {
        view.startAnimation(AnimUtils.fadeIn());
        return this;
    }

    private LoginActivity fadeOut(final View view) {
        view.startAnimation(AnimUtils.fadeOut());
        return this;
    }

    private LoginActivity show(final View view) {
        ViewUtils.setGone(view, false);
        return this;
    }

    private LoginActivity hide(final View view) {
        ViewUtils.setGone(view, true);
        return this;
    }

    private void checkCurrentAccount() {
        final Account availableAccounts[] = mAccountManager.getAccountsByType(AccountGeneral.ACCOUNT_TYPE);
        if (availableAccounts.length != 0) {
            //TODO make a picker if length > 1
            getExistingAccountAuthToken(availableAccounts[0], AccountGeneral.AUTHTOKEN_TYPE_FULL_ACCESS);
        }
    }

    private void getExistingAccountAuthToken(Account account, String authTokenType) {
        final AccountManagerFuture<Bundle> future = mAccountManager.getAuthToken(account, authTokenType, null, this, null, null);

        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Bundle bnd = future.getResult();

                    final String authtoken = bnd.getString(AccountManager.KEY_AUTHTOKEN);
                    if (!TextUtils.isEmpty(authtoken)) {
                        startFamilyMain();
                    }
                    Log.e("p37td8", "GetToken Bundle is " + bnd);
                    Log.e("p37td8", "auth : " + authtoken);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }).start();
    }

    private void startFamilyMain() {
        Intent intent = new Intent(this, FamilyMain.class);
        startActivity(intent);
        finish();
    }

}
