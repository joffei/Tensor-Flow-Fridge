package com.example.android.sixsigma.tensorflowfridge;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.ImageView;
import android.widget.TextView;

public class newItemActivity extends AppCompatActivity {

    private static ImageView itemImage;
    private static TextView itemName;
    private static DatePicker expirationDate;
    private static Button save;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_item);

        itemImage = (ImageView) findViewById(R.id.item_image);
        itemName = (TextView) findViewById(R.id.item_name);
        expirationDate = (DatePicker) findViewById(R.id.expiration_date);
        save = (Button) findViewById(R.id.save_button);


    }
}
