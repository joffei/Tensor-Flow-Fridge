package com.example.android.sixsigma.tensorflowfridge;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    public static ListView fridgeList;
    public static Button newItemButton;
    private static final int REQUEST_IMAGE_CAPTURE = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        fridgeList = (ListView) findViewById(R.id.fridge_list);
        newItemButton = (Button) findViewById(R.id.new_item_button);

        SharedPreferences.Editor imagesEditor = MainActivity.this.getSharedPreferences(getString(R.string.images_preference), Context.MODE_PRIVATE).edit();
        SharedPreferences.Editor namesEditor = MainActivity.this.getSharedPreferences(getString(R.string.names_preference), Context.MODE_PRIVATE).edit();
        SharedPreferences.Editor expEditor = MainActivity.this.getSharedPreferences(getString(R.string.expiration_preference), Context.MODE_PRIVATE).edit();

        ArrayList<FridgeListItem> items = new ArrayList<FridgeListItem>();

        FridgeArrayAdapter adapter = new FridgeArrayAdapter(MainActivity.this, items);

        fridgeList.setAdapter(adapter);

        newItemButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });

        fridgeList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

            }
        });
    }

    public void fillArrayContent(ArrayList<FridgeListItem> items, int maxIndex){
        SharedPreferences imagePref = MainActivity.this.getSharedPreferences(getString(R.string.images_preference), Context.MODE_PRIVATE);
        SharedPreferences namePref = MainActivity.this.getSharedPreferences(getString(R.string.names_preference), Context.MODE_PRIVATE);
        SharedPreferences expPref = MainActivity.this.getSharedPreferences(getString(R.string.expiration_preference), Context.MODE_PRIVATE);


    }

}
