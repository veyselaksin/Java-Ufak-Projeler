package com.example.landmarkbook;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listView();

    }

    private void listView(){
        ListView listView=findViewById(R.id.listView);


        //Datas
        final ArrayList<String> arrayList=new ArrayList<>();

        arrayList.add("Pisa");
        arrayList.add("Collesseo");
        arrayList.add("Eiffel");
        arrayList.add("London Bridge");

        final ArrayList<String> countryList=new ArrayList<>();
        countryList.add("İtaly");
        countryList.add("İtaly");
        countryList.add("France");
        countryList.add("United Kingdom");

        Bitmap pisa= BitmapFactory.decodeResource(getApplicationContext().getResources(),R.drawable.pisa);
        Bitmap eiffel=BitmapFactory.decodeResource(getApplicationContext().getResources(),R.drawable.eiffel);
        Bitmap collesseo=BitmapFactory.decodeResource(getApplicationContext().getResources(),R.drawable.collesseo);
        Bitmap londonbridge=BitmapFactory.decodeResource(getApplicationContext().getResources(),R.drawable.londonbridge);

        final ArrayList<Bitmap> landMarkImages=new ArrayList<>();
        landMarkImages.add(pisa);
        landMarkImages.add(collesseo);
        landMarkImages.add(eiffel);
        landMarkImages.add(londonbridge);
        // ListView
        ArrayAdapter arrayAdapter=new ArrayAdapter(this, android.R.layout.simple_list_item_1,arrayList);
        listView.setAdapter(arrayAdapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent=new Intent(getApplicationContext(),DetailsActivity.class);
                intent.putExtra("landMarkName", arrayList.get(position));
                intent.putExtra("countryName",countryList.get(position));

                Singleton singleton=Singleton.getInstance();
                singleton.setSelectedItem(landMarkImages.get(position));
                startActivity(intent);
            }
        });
    }
}
