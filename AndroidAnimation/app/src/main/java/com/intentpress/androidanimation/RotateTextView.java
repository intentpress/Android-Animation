package com.intentpress.androidanimation;

import android.animation.ObjectAnimator;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class RotateTextView extends AppCompatActivity {
    public TextView txtMessage;
    public Button mainPage;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rotate_text);
        txtMessage = (TextView) findViewById(R.id.textView);
        mainPage =(Button) findViewById(R.id.mainView);
        mainPage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(RotateTextView.this , MainActivity.class);
                startActivity(intent);
                finish();
            }
        });
        ObjectAnimator anim
                = ObjectAnimator.ofFloat(txtMessage, "rotationY", 0.0f,180.0f);
        anim.setDuration(3000);
        anim.start();
    }
}