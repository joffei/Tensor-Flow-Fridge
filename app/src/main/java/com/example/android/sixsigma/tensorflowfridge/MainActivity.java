package com.example.android.sixsigma.tensorflowfridge;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.net.Uri;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ListView;
import android.app.Activity;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.os.Bundle;
import android.util.SparseArray;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.EditText;

import com.google.android.gms.appindexing.Action;
import com.google.android.gms.appindexing.AppIndex;
import com.google.android.gms.appindexing.Thing;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.vision.Frame;
import com.google.android.gms.vision.barcode.Barcode;
import com.google.android.gms.vision.barcode.BarcodeDetector;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    public static ListView fridgeList;
    public static Button newItemButton;
    public static ImageButton searchBarcode;
    private static final int REQUEST_IMAGE_CAPTURE = 1;
    /**
     * ATTENTION: This was auto-generated to implement the App Indexing API.
     * See https://g.co/AppIndexing/AndroidStudio for more information.
     */
    private GoogleApiClient client;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        fridgeList = (ListView) findViewById(R.id.fridge_list);
        newItemButton = (Button) findViewById(R.id.new_item_button);
        searchBarcode = (ImageButton) findViewById(R.id.ScanBarcode);



        SharedPreferences.Editor imagesEditor = MainActivity.this.getSharedPreferences(getString(R.string.images_preference), Context.MODE_PRIVATE).edit();
        SharedPreferences.Editor namesEditor = MainActivity.this.getSharedPreferences(getString(R.string.names_preference), Context.MODE_PRIVATE).edit();
        SharedPreferences.Editor expEditor = MainActivity.this.getSharedPreferences(getString(R.string.expiration_preference), Context.MODE_PRIVATE).edit();

        ArrayList<FridgeListItem> items = new ArrayList<FridgeListItem>();

        FridgeArrayAdapter adapter = new FridgeArrayAdapter(MainActivity.this, items);

        fridgeList.setAdapter(adapter);

        searchBarcode.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                changetoBarCodeActivity();
            }
        });

        newItemButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                changeActivity();
            }
        });

        fridgeList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

            }
        });
        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.
        client = new GoogleApiClient.Builder(this).addApi(AppIndex.API).build();
    }


    public void changeActivity() {
        Intent intentADD = new Intent(this, newItemActivity.class);
        startActivity(intentADD);
    }
    public void changetoBarCodeActivity() {
        Intent intentADD = new Intent(this, barcode_Scanner.class);
        startActivity(intentADD);
    }



    public void fillArrayContent(ArrayList<FridgeListItem> items, int maxIndex) {
        SharedPreferences imagePref = MainActivity.this.getSharedPreferences(getString(R.string.images_preference), Context.MODE_PRIVATE);
        SharedPreferences namePref = MainActivity.this.getSharedPreferences(getString(R.string.names_preference), Context.MODE_PRIVATE);
        SharedPreferences expPref = MainActivity.this.getSharedPreferences(getString(R.string.expiration_preference), Context.MODE_PRIVATE);


    }

    /**
     * ATTENTION: This was auto-generated to implement the App Indexing API.
     * See https://g.co/AppIndexing/AndroidStudio for more information.
     */
    public Action getIndexApiAction() {
        Thing object = new Thing.Builder()
                .setName("Main Page") // TODO: Define a title for the content shown.
                // TODO: Make sure this auto-generated URL is correct.
                .setUrl(Uri.parse("http://[ENTER-YOUR-URL-HERE]"))
                .build();
        return new Action.Builder(Action.TYPE_VIEW)
                .setObject(object)
                .setActionStatus(Action.STATUS_TYPE_COMPLETED)
                .build();
    }

    @Override
    public void onStart() {
        super.onStart();

        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.
        client.connect();
        AppIndex.AppIndexApi.start(client, getIndexApiAction());
    }

    @Override
    public void onStop() {
        super.onStop();

        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.
        AppIndex.AppIndexApi.end(client, getIndexApiAction());
        client.disconnect();
    }
}
