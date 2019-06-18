package com.agri.atef.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.agri.atef.myapplication.Adabter.fruitsAdabter;
import com.agri.atef.myapplication.model.frt;

import java.util.ArrayList;
import java.util.List;


public class articles extends AppCompatActivity {

    private RecyclerView recyclerView;
    private fruitsAdabter adabter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_articles);

        recyclerView =  findViewById(R.id.rvfruits);

        setupRecyclerView();
        sendData();
    }
    private void setupRecyclerView() {
        LinearLayoutManager mngr = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(mngr);
        adabter = new fruitsAdabter(this);
        recyclerView.setAdapter(adabter);
    }
    void sendData(){

        List<frt> frtsList = new ArrayList<>();

        String [] names = {"طماطم" , "فل فل اخضر","بطاطس","خيار","بازنجان"};
        int [] imgs = {R.drawable.tomatoes , R.drawable.felfel,R.drawable.botato,R.drawable.khyar,R.drawable.betengan};

        for (int i = 0; i <names.length ; i++) {
            frtsList.add(new frt(names[i] , imgs[i]));
        }

        adabter.setDataSource(frtsList);
        adabter.notifyDataSetChanged();

    }

    public void gotohome(View view) {
        Intent intent = new Intent(articles.this, navigation.class);
        startActivity(intent);
    }

//    public void gotocropsdept(View view) {
//        Intent intent = new Intent(articles.this, cropsdept.class);
//        startActivity(intent);
//    }

    public void gotoknowlegegate(View view) {
        Intent intent = new Intent(articles.this, knowlegegate.class);
        startActivity(intent);
    }

    public void gotoblight(View view) {
        Intent intent = new Intent(articles.this, blight.class);
        startActivity(intent);
    }

    public void previous(View view) {
        Intent intent = new Intent(articles.this, knowlegegate.class);
        startActivity(intent);
    }
}
