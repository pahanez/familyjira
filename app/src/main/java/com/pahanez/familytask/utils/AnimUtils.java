package com.pahanez.familytask.utils;

import android.view.animation.Animation;
import android.view.animation.AnimationUtils;

import com.pahanez.familytask.Application;
import com.pahanez.familytask.R;

import javax.inject.Inject;

public class AnimUtils {

    @Inject static Application mApplication;

    public static Animation fadeOut(AnimationListenerImpl listener ){
        return getAnimation(android.R.anim.fade_out ,listener);
    }

    public static Animation fadeOut(){
        return getAnimation(android.R.anim.fade_out);
    }

    public static Animation fadeIn(){
        return getAnimation(android.R.anim.fade_in );
    }

    public static Animation verticalOutBottom(AnimationListenerImpl listener){
       return getAnimation(R.anim.vertical_out_bottom ,listener);
    }

    public static Animation verticalInTopScale(AnimationListenerImpl listener){
        return getAnimation(R.anim.vertical_in_top_scale ,listener);
    }


    public static Animation getAnimation(int animationId , AnimationListenerImpl listener){
        Animation animation =  AnimationUtils.loadAnimation(mApplication,animationId);
        animation.setAnimationListener(listener);
        return animation;
    }

    public static Animation getAnimation(int animationId){
        return AnimationUtils.loadAnimation(mApplication,animationId);
    }


    public static class AnimationListenerImpl implements Animation.AnimationListener{

        @Override
        public void onAnimationStart(Animation animation) {

        }

        @Override
        public void onAnimationEnd(Animation animation) {

        }

        @Override
        public void onAnimationRepeat(Animation animation) {

        }
    }
}
