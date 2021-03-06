package com.skyfishjy.ripplebackground.sample;

import java.util.ArrayList;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.widget.ImageView;

import com.skyfishjy.library.RippleBackground;
import com.skyfishjy.library.ripplebackground.sample.R;


public class MainActivity extends Activity {

    private ImageView foundDevice;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final RippleBackground rippleBackground = (RippleBackground) findViewById(R.id.content);

        final Handler handler = new Handler();
        rippleBackground.startRippleAnimation();


        foundDevice = (ImageView) findViewById(R.id.foundDevice);
        foundDevice.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


//                if (rippleBackground.isRippleAnimationRunning()) {
//                    rippleBackground.stopRippleAnimation();
//                }
//
//                rippleBackground.setRippleAmount(10);
//                rippleBackground.setRippleColor(getColor(android.R.color.holo_green_light));
//                rippleBackground.startRippleAnimation();

               // rippleBackground.stopRippleAnimation();
               // rippleBackground.setRippleColor(getColor(android.R.color.holo_green_light));
                rippleBackground.setRippleAmount(1);
                rippleBackground.startRippleAnimation();
            }
        });
        ImageView button = (ImageView) findViewById(R.id.centerImage);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });
    }

    private void foundDevice() {
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.setDuration(400);
        animatorSet.setInterpolator(new AccelerateDecelerateInterpolator());
        ArrayList<Animator> animatorList   = new ArrayList<Animator>();
        ObjectAnimator      scaleXAnimator = ObjectAnimator.ofFloat(foundDevice, "ScaleX", 0f, 1.2f, 1f);
        animatorList.add(scaleXAnimator);
        ObjectAnimator scaleYAnimator = ObjectAnimator.ofFloat(foundDevice, "ScaleY", 0f, 1.2f, 1f);
        animatorList.add(scaleYAnimator);
        animatorSet.playTogether(animatorList);
        foundDevice.setVisibility(View.VISIBLE);
        animatorSet.start();
    }
}
