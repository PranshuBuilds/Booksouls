package com.crazy.booksoul;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityOptionsCompat;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.WindowManager;
import android.widget.Toast;

import com.crazy.booksoul.preference.LanguageActivity;

public class SplashActivity extends AppCompatActivity {
    private static int SPLASH_SCREEN_TIME=1000;

    private static final String RUN = "run";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);

        Boolean isFirstRun = getSharedPreferences("run", MODE_PRIVATE)
                .getBoolean("isFirstRun", true);

        if (isFirstRun) {
            //show start activity

            new Handler().postDelayed(new Runnable() {
                @Override
                public void run() {
                    setContentView(R.layout.activity_splash);
                    Bundle bundle = ActivityOptionsCompat.makeCustomAnimation(getApplicationContext(),
                            android.R.anim.fade_in, android.R.anim.fade_out).toBundle();
                    startActivity(new Intent(SplashActivity.this, LanguageActivity.class), bundle);
                    finish();
                }
            }, SPLASH_SCREEN_TIME);
            Toast.makeText(this, "First Run", Toast.LENGTH_LONG)
                    .show();


        }else{
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                setContentView(R.layout.activity_splash);
                Bundle bundle = ActivityOptionsCompat.makeCustomAnimation(getApplicationContext(),
                        android.R.anim.fade_in, android.R.anim.fade_out).toBundle();
                startActivity(new Intent(SplashActivity.this, MainActivity.class),bundle);
                finish();
            }
        },SPLASH_SCREEN_TIME);}
    }
}