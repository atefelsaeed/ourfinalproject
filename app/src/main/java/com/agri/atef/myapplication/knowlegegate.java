package com.agri.atef.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

public class knowlegegate extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_knowlegegate);
    }

    public void ourvedios(View view) {
        Intent intent = new Intent(knowlegegate.this, vedios.class);
        startActivity(intent);
    }

    public void ourarticles(View view) {
        Intent intent = new Intent(knowlegegate.this, articles.class);
        startActivity(intent);
    }

    public void gotohome(View view) {
        Intent intent = new Intent(knowlegegate.this, navigation.class);
        startActivity(intent);
    }

    public void previous(View view) {
        Intent intent = new Intent(knowlegegate.this, Main2Activity.class);
        startActivity(intent);
    }

    public void gotocropsdept(View view) {
        Intent intent = new Intent(knowlegegate.this, cropsdept.class);
        startActivity(intent);
    }

    public void gotoblight(View view) {
        Intent intent = new Intent(knowlegegate.this, blight.class);
        startActivity(intent);
    }

    public void gotoknowlegegate(View view) {
        Intent intent = new Intent(knowlegegate.this, knowlegegate.class);
        startActivity(intent);
    }

}
