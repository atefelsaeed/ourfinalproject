package com.agri.atef.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.SearchView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import com.agri.atef.myapplication.Adabter.fruitsAdabter;
import com.agri.atef.myapplication.model.frt;

import java.util.ArrayList;
import java.util.List;

public class fruits extends AppCompatActivity implements SearchView.OnQueryTextListener {

    private RecyclerView recyclerView;
    private fruitsAdabter adabter;
     private Toolbar toolbar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fruits);

        toolbar=findViewById(R.id.toolbar2) ;
        setSupportActionBar(toolbar);
        recyclerView =  findViewById(R.id.rvfruits);

        setupRecyclerView();
        sendData();
    }

    //this is method to make my code more organized
    private void setupRecyclerView() {
        LinearLayoutManager mngr = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(mngr);
        adabter = new fruitsAdabter(this);
        recyclerView.setAdapter(adabter);

//        List<frt> dataSource = getDataSource();
//        adabter.setDataSource(dataSource);
//        adabter.notifyDataSetChanged();

    }


    void sendData(){

        List<frt> frtsList = new ArrayList<>();

        String [] names = {"البرتقال" , "خوخ","عنب احمر","موز"};
        int [] imgs = {R.drawable.orange , R.drawable.peach,R.drawable.redbearberry,R.drawable.banana};

        for (int i = 0; i <names.length ; i++) {
            frtsList.add(new frt(names[i] , imgs[i]));
        }

        adabter.setDataSource(frtsList);
        adabter.notifyDataSetChanged();

    }

//    private List<frt> getDataSource() {
//        List<frt> frtList = new ArrayList<>();
//        frtList.add(new frt("Orange", R.drawable.orange));
//        frtList.add(new frt("Orange", R.drawable.orange));
//        frtList.add(new frt("Orange", R.drawable.orange));
//        frtList.add(new frt("Orange", R.drawable.orange));
//        return frtList;
//    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.example_menu, menu);
        MenuItem menuItem = menu.findItem(R.id.action_search);
        SearchView searchView = (SearchView) menuItem.getActionView();
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                adabter.getFilter().filter(newText);

                return false;
            }
        });

        return true;
    }

    @Override
    public boolean onQueryTextSubmit(String query) {
        return false;
    }

    @Override
    public boolean onQueryTextChange(String newText) {
        return false;
    }

//    public void previous(View view) {
//        Intent intent = new Intent(fruits.this, cropsdept.class);
//        startActivity(intent);
//    }

    public void gotohome(View view) {
        Intent intent = new Intent(fruits.this, navigation.class);
        startActivity(intent);
    }

//    public void gotocropsdept(View view) {
//        Intent intent = new Intent(fruits.this, cropsdept.class);
//        startActivity(intent);
//    }

    public void gotoknowlegegate(View view) {
        Intent intent = new Intent(fruits.this, knowlegegate.class);
        startActivity(intent);
    }

    public void gotoblight(View view) {
        Intent intent = new Intent(fruits.this, blight.class);
        startActivity(intent);
    }
}
