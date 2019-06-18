package com.agri.atef.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;

public class navigation extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_navigation);
        Toolbar toolbar =  findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);



        DrawerLayout drawer =  findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView =  findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer =  findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }



    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_registeration) {

            // Handle the camera action
        } else if (id == R.id.nav_home) {

        } else if (id == R.id.nav_guid) {
        startActivity(new Intent(navigation.this,Main2Activity.class) );

        } else if (id == R.id.nav_academic) {
            startActivity(new Intent(navigation.this,knowlegegate.class));
        } else if (id == R.id.nav_insects) {
            startActivity(new Intent(navigation.this,blight.class));
        } else if (id == R.id.nav_favourite) {

        }
        else if (id == R.id.nav_planting) {
          startActivity(new Intent(navigation.this, planting.class));
        }
        else if (id == R.id.nav_contact) {

        }


        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
    public void sign(View V ){

        Intent intent=new Intent(navigation.this,Main2Activity.class);
        startActivity(intent);
    }

    public void guid(View view) {
        Intent intent=new Intent(navigation.this,Main2Activity.class);
        startActivity(intent);
    }


    public void gate(View view) {
        Intent intent=new Intent(navigation.this,knowlegegate.class);
        startActivity(intent);
    }

}
