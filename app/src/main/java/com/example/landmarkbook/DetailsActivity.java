package com.example.landmarkbook;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class DetailsActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);
        datas();
    }

    //Veriler girildi

    public void datas(){
        ImageView imageView=findViewById(R.id.imageView);
        TextView countryNameText=findViewById(R.id.countryName);
        TextView landNameText=findViewById(R.id.landName);

        Intent intent=getIntent();
        String landMarkNames=intent.getStringExtra("landMarkName");;
        String countryNames=intent.getStringExtra("countryName");
        countryNameText.setText(countryNames);
        landNameText.setText(landMarkNames);

        Singleton singleton=Singleton.getInstance();
        imageView.setImageBitmap(singleton.getSelectedItem());

    }
}
