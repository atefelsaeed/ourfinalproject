//package com.example.atef.myapplication;
//
//import android.content.Intent;
//import android.os.Bundle;
//import android.support.v7.app.AppCompatActivity;
//import android.view.View;
//import android.widget.ImageView;
//import android.widget.TextView;
//
//public class showitems extends AppCompatActivity {
//
//    private static final String TAG="showitems";
//
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_showitems);
//      //  Log.d(TAG,"oncreate:started.");
//        getIncomingIntent();
//    }
//
//    private void getIncomingIntent() {
//
//        if(getIntent().hasExtra("name")&&getIntent().hasExtra("img")){
//            String name=getIntent().getExtras().getString("name");
//            int img=getIntent().getExtras().getInt("img");
//            setImage(name,img);
//
//        }
//    }
//
//    private void setImage(String name, int img) {
//        TextView namet=findViewById(R.id.textView5);
//        namet.setText(name);
//
//        ImageView image=findViewById(R.id.imageView8);
//        image.setImageResource(img);
//      //  Glide.with(this).asBitmab().load(name).into(imageView8);
//    }
//
//    public void previous(View view) {
//        Intent intent = new Intent(showitems.this, Main2Activity.class);
//        startActivity(intent);
//    }
//}
package com.agri.atef.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class showitems extends AppCompatActivity {

    private static final String TAG="showitems";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_showitems);
        //  Log.d(TAG,"oncreate:started.");
        getIncomingIntent();
    }

    private void getIncomingIntent() {

        if(getIntent().hasExtra("name")&&getIntent().hasExtra("img")){
            String name=getIntent().getExtras().getString("name");
            int img=getIntent().getExtras().getInt("img");
            setImage(name,img);

        }
    }

    private void setImage(String name, int img) {
        TextView namet=findViewById(R.id.textView5);
        namet.setText(name);

        ImageView image=findViewById(R.id.imageView8);
        image.setImageResource(img);
        //  Glide.with(this).asBitmab().load(name).into(imageView8);
    }

    public void previous(View view) {
        Intent intent = new Intent(showitems.this, Main2Activity.class);
        startActivity(intent);
    }
}