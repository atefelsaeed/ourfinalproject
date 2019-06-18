package com.agri.atef.myapplication;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;

public class SplashActivity extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        Thread mythread = new Thread(){
            @Override
            public void run() {
                try {
                    sleep(2000);

                    Intent intent = new Intent(SplashActivity.this ,navigation.class);
                    startActivity(intent);
                    finish();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                };
            }
        };
        mythread.start();
    }
}
