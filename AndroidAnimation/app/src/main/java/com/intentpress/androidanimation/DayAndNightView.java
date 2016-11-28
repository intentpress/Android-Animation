package com.intentpress.androidanimation;

import android.animation.AnimatorInflater;
import android.animation.AnimatorSet;
import android.animation.ArgbEvaluator;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class DayAndNightView extends AppCompatActivity {
    Button nightViewButton , dayViewButton , mainPage;
    ImageView moonImage, sunImage;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_day_night_view);
        dayViewButton = (Button)findViewById(R.id.day);
        nightViewButton = (Button)findViewById(R.id.night);
        mainPage = (Button)findViewById(R.id.mainActivity);
        moonImage = (ImageView) findViewById(R.id.moon);
        sunImage = (ImageView) findViewById(R.id.sun);

        mainPage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(DayAndNightView.this , MainActivity.class);
                startActivity(intent);
                finish();
            }
        });
        dayViewButton.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                sunImage.setVisibility(View.VISIBLE);
                AnimatorSet sunRise = (AnimatorSet) AnimatorInflater.loadAnimator(DayAndNightView.this, R.animator.sun_swing);
                sunRise.setTarget(sunImage);
                sunRise.start();
                AnimatorSet moonfall = (AnimatorSet) AnimatorInflater.loadAnimator(DayAndNightView.this, R.animator.moon_swing_away);
                moonfall.setTarget(moonImage);
                moonfall.start();
                ValueAnimator skyAnim = ObjectAnimator.ofInt
                        (findViewById(R.id.view_layout), "backgroundColor",
                                Color.rgb(0x00, 0x66, 0x99), Color.rgb(0x66, 0xcc, 0xff));
                skyAnim.setDuration(3000);
                skyAnim.setRepeatMode(ValueAnimator.REVERSE);
                skyAnim.setEvaluator(new ArgbEvaluator());
                skyAnim.start();
                ObjectAnimator cloudAnim =
                        ObjectAnimator.ofFloat(findViewById(R.id.cloud1), "x", -350);
                cloudAnim.setDuration(3000);
                cloudAnim.start();
                ObjectAnimator cloudAnim2 = ObjectAnimator.ofFloat(findViewById(R.id.cloud2), "x", -300);
                cloudAnim2.setDuration(3000);
                cloudAnim2.setRepeatMode(ValueAnimator.REVERSE);
                cloudAnim2.start();
                ObjectAnimator cloudAnim3 = ObjectAnimator.ofFloat(findViewById(R.id.cloud3), "x", -300);
                cloudAnim3.setDuration(3000);
                cloudAnim3.setRepeatMode(ValueAnimator.REVERSE);
                cloudAnim3.start();

                return false;
            }
        });
        nightViewButton.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                moonImage.setVisibility(View.VISIBLE);
                AnimatorSet moonRise = (AnimatorSet) AnimatorInflater.loadAnimator(DayAndNightView.this, R.animator.moon_swing);
                moonRise.setTarget(moonImage);
                moonRise.start();
                AnimatorSet sunFall = (AnimatorSet) AnimatorInflater.loadAnimator(DayAndNightView.this, R.animator.sun_swing_away);
                sunFall.setTarget(sunImage);
                sunFall.start();
                ValueAnimator skyAnim = ObjectAnimator.ofInt
                        (findViewById(R.id.view_layout), "backgroundColor",
                                Color.rgb(0x66, 0xcc, 0xff), Color.rgb(0x00, 0x66, 0x99));
                skyAnim.setDuration(3000);
                skyAnim.setRepeatMode(ValueAnimator.REVERSE);
                skyAnim.setEvaluator(new ArgbEvaluator());
                skyAnim.start();

                ObjectAnimator cloudAnim =
                        ObjectAnimator.ofFloat(findViewById(R.id.cloud1), "x", 350);
                cloudAnim.setDuration(3000);
                cloudAnim.setRepeatMode(ValueAnimator.REVERSE);
                cloudAnim.start();
                ObjectAnimator cloudAnim2 = ObjectAnimator.ofFloat(findViewById(R.id.cloud2), "x", 300);
                cloudAnim2.setDuration(3000);
                cloudAnim2.setRepeatMode(ValueAnimator.REVERSE);
                cloudAnim2.start();
                ObjectAnimator cloudAnim3 = ObjectAnimator.ofFloat(findViewById(R.id.cloud3), "x", 300);
                cloudAnim3.setDuration(3000);
                cloudAnim3.setRepeatMode(ValueAnimator.REVERSE);
                cloudAnim3.start();
                return false;
            }
        });
    }

}