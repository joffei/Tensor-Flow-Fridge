package com.example.android.sixsigma.tensorflowfridge;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import static android.provider.AlarmClock.EXTRA_MESSAGE;

public class newItemActivity extends AppCompatActivity {

    private static ImageView itemImage;
    private static TextView itemName;
    private static DatePicker expirationDate;
    private static Button save;
    private static EditText foodName;
    private String foodname;
    private String Date;
    private int day;
    private int month;
    private int year;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_item);

        foodName = (EditText) findViewById(R.id.Food_Name);
        itemImage = (ImageView) findViewById(R.id.item_image);
        itemName = (TextView) findViewById(R.id.item_name);
        expirationDate = (DatePicker) findViewById(R.id.expiration_date);
        // From here to the bottom done by Darrin Cation
        save = (Button) findViewById(R.id.save_button);
        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

               foodname = foodName.getText().toString();
                day = expirationDate.getDayOfMonth();
                month = expirationDate.getMonth();
                year = expirationDate.getYear();

                Date =foodname + " Expires on " + month + "/" + day + "/" + year;
                itemName.setText(Date);

                changetoBarcodeGen(day, month, year, foodname);

            }
        });
    }


        public void changetoBarcodeGen(int day, int month, int year, String foodName) {

            Intent intentADD = new Intent(this, Generate_barcode.class);
            intentADD.putExtra(EXTRA_MESSAGE, foodName);
            intentADD.putExtra(EXTRA_MESSAGE, month);
            intentADD.putExtra(EXTRA_MESSAGE, day);
            intentADD.putExtra(EXTRA_MESSAGE, year);

            startActivity(intentADD);

        }
}

