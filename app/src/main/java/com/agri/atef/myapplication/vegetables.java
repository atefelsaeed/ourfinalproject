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

public class vegetables extends AppCompatActivity implements SearchView.OnQueryTextListener {

    private RecyclerView recyclerView;
    private fruitsAdabter adabter;
    private List<frt> frtsList;
    private Toolbar toolbar;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_vegetables);

        toolbar=findViewById(R.id.toolbar2) ;
        setSupportActionBar(toolbar);

        //ActionBar actionBar=getSupportActionBar();
        //((android.support.v7.app.ActionBar) actionBar).setDefaultDisplayHomeAsUpEnabled();

        recyclerView = findViewById(R.id.rvfruits);
        setupRecyclerView();
        sendData();
    }

    private void setupRecyclerView() {
        LinearLayoutManager mngr = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(mngr);
        adabter = new fruitsAdabter(this);
        recyclerView.setAdapter(adabter);
    }

    void sendData() {

        frtsList = new ArrayList<>();

        String[] names = {"طماطم", "فل فل اخضر", "بطاطس", "خيار", "بازنجان"};
        int[] imgs = {R.drawable.tomatoes, R.drawable.felfel, R.drawable.botato, R.drawable.khyar, R.drawable.betengan};

        for (int i = 0; i < names.length; i++) {
            frtsList.add(new frt(names[i], imgs[i]));
        }

        adabter.setDataSource(frtsList);
        adabter.notifyDataSetChanged();

    }

    public void gotohome(View view) {
        Intent intent = new Intent(vegetables.this, navigation.class);
        startActivity(intent);
    }

//    public void gotocropsdept(View view) {
//        Intent intent = new Intent(vegetables.this, cropsdept.class);
//        startActivity(intent);
//    }

    public void gotoknowlegegate(View view) {
        Intent intent = new Intent(vegetables.this, knowlegegate.class);
        startActivity(intent);
    }

    public void gotoblight(View view) {
        Intent intent = new Intent(vegetables.this, blight.class);
        startActivity(intent);
    }
//
//    public void previous(View view) {
//        Intent intent = new Intent(vegetables.this, cropsdept.class);
//        startActivity(intent);
//    }

    //menu search

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
}

