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

import com.agri.atef.myapplication.Adabter.videoAdabter;
import com.agri.atef.myapplication.model.ourVideoList;

import java.util.ArrayList;
import java.util.List;

public class vedios extends AppCompatActivity implements SearchView.OnQueryTextListener  {

    private RecyclerView recyclerView;
    private videoAdabter adabter;
    public List<ourVideoList> videoList;
    private Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_vedios);

        toolbar=findViewById(R.id.toolbar2) ;
        setSupportActionBar(toolbar);

        recyclerView = findViewById(R.id.rvVideos);
        setupRecyclerView();
        sendData();
    }

    private void setupRecyclerView() {
        LinearLayoutManager mngr = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(mngr);
        adabter = new videoAdabter(this);
        recyclerView.setAdapter(adabter);
//        fetchVideosFromGallery();
    }

//    private void fetchVideosFromGallery() {
//        Uri uri;
//        Cursor cursor;
//        int column_index_data,column_index_folder_name,column_index_id,thum;
//        String absolutePathImage=null;
//
//        uri= MediaStore.Video.Media.EXTERNAL_CONTENT_URI;
//
//        String[] projection={MediaStore.MediaColumns.DATA,
//        MediaStore.Video.Media.BUCKET_DISPLAY_NAME,
//        MediaStore.Video.Media._ID,
//        MediaStore.Video.Thumbnails.DATA};
//    }


    void sendData() {

        videoList = new ArrayList<>();

        String[] names = {"عمر", "فل فل اخضر", "بطاطس", "خيار", "بازنجان"};
        int[] videos = {R.raw.omar, R.raw.abohabiba, R.raw.shawky, R.raw.tefa, R.raw.omar};

        for (int i = 0; i < names.length; i++) {
            videoList.add(new ourVideoList(names[i], videos[i]));
        }

        adabter.setDataSource(videoList);
        adabter.notifyDataSetChanged();

    }


    public void previous(View view) {
        Intent intent = new Intent(vedios.this,knowlegegate.class);
        startActivity(intent);
    }

    public void gotohome(View view) {
        Intent intent = new Intent(vedios.this,navigation.class);
        startActivity(intent);
    }

    public void gotoknowlegegate(View view) {
        Intent intent = new Intent(vedios.this,knowlegegate.class);
        startActivity(intent);
    }

//    public void gotocropsdept(View view) {
//        Intent intent = new Intent(vedios.this,cropsdept.class);
//        startActivity(intent);
//    }

    public void gotoblight(View view) {
        Intent intent = new Intent(vedios.this,blight.class);
        startActivity(intent);
    }

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
