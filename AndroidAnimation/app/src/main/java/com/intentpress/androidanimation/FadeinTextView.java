package com.intentpress.androidanimation;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.TextView;


public class FadeinTextView extends AppCompatActivity {
    TextView txtMessage;
    Animation animFadein;
    Button mainPage;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fade_in);
        txtMessage = (TextView) findViewById(R.id.textView);
        mainPage = (Button) findViewById(R.id.mainView);
        mainPage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(FadeinTextView.this , MainActivity.class);
                startActivity(intent);
                finish();
            }
        });
        animFadein = AnimationUtils.loadAnimation(getApplicationContext(),R.anim.fade_in);
        txtMessage.setVisibility(View.VISIBLE);
        txtMessage.setAnimation(animFadein);
    }
}