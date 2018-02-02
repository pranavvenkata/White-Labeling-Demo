package com.actigage.whitelabelingdemo;

import android.app.Activity;
import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Window;

public class SplashActivity extends Activity {
<<<<<<< HEAD

=======
>>>>>>> feature/feature_green_flavor
    private static int SPLASH_TIME_OUT = 3000;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_splash);
        new Handler().postDelayed(new Runnable() {
            @Override
<<<<<<< HEAD
=======
        setContentView(R.layout.activity_splash2);
        new Handler().postDelayed(new Runnable() {
             @Override
>>>>>>> feature/feature_red_flavor
=======
>>>>>>> feature/feature_green_flavor
            public void run() {
                Intent i = new Intent(SplashActivity.this, MainActivity.class);
                startActivity(i);
                finish();
<<<<<<< HEAD
            }
        }, SPLASH_TIME_OUT);
=======
         }
        },SPLASH_TIME_OUT);
>>>>>>> feature/feature_green_flavor
    }
}
