package com.agri.atef.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

public class Main2Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
    }

    public void previous(View view) {
        Intent intent = new Intent(Main2Activity.this, navigation.class);
        startActivity(intent);
    }

    public void gotohome(View view) {
        Intent intent = new Intent(Main2Activity.this, navigation.class);
        startActivity(intent);
    }

    public void gotoknowlegegate(View view) {
        Intent intent = new Intent(Main2Activity.this, knowlegegate.class);
        startActivity(intent);
    }

    public void gotoblight(View view) {
        Intent intent = new Intent(Main2Activity.this, blight.class);
        startActivity(intent);
    }

    public void gotocropsdept(View view) {
        Intent intent = new Intent(Main2Activity.this, cropsdept.class);
        startActivity(intent);
    }
}
