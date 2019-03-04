package com.example.geddi;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);


        Animation anim = AnimationUtils.loadAnimation(this, R.anim.bounce_anim);
        ImageView logo = findViewById(R.id.logo);

        logo.startAnimation(anim);

        int STATIC_SPLASH_TIMEOUT = 1800;
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent homeIntent = new Intent(MainActivity.this, AccountCreationPage.class);
                startActivity(homeIntent);
                finish();
            }
        }, STATIC_SPLASH_TIMEOUT);
    }
}