package com.intentpress.androidanimation;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.RotateAnimation;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    public Button rotateTextView, fadeInTextView , dayAndNightAnimation;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        rotateTextView = (Button) findViewById(R.id.rotate_activity);
        fadeInTextView = (Button) findViewById(R.id.fadein_activity);
        dayAndNightAnimation = (Button) findViewById(R.id.day_night);
        dayAndNightAnimation.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this , DayAndNightView.class);
                startActivity(intent);
            }
        });
        fadeInTextView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this , FadeinTextView.class);
                startActivity(intent);
            }
        });
        rotateTextView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this , RotateTextView.class);
                startActivity(intent);
            }
        });
    }
}
