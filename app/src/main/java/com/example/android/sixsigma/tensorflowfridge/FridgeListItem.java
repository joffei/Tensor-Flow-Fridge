package com.example.android.sixsigma.tensorflowfridge;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by mobiledev on 11/25/2016.
 */

public class FridgeListItem {

    private static ImageView image;
    private static TextView name;
    private static TextView expiration;

    public FridgeListItem(int image, String name, String expiration){
        this.image.setImageResource(image);
        this.name.setText(name);
        this.expiration.setText(expiration);
    }

    public static ImageView getImage() {
        return image;
    }

    public static int getImageId(){
        return image.getId();
    }

    public static TextView getName() {
        return name;
    }

    public static TextView getExpiration() {
        return expiration;
    }

    public static void setImage(ImageView image) {
        FridgeListItem.image = image;
    }

    public static void setImage(int image){
        FridgeListItem.image.setImageResource(image);
    }

    public static void setName(TextView name) {
        FridgeListItem.name = name;
    }

    public static void setName(String name){
        FridgeListItem.name.setText(name);
    }

    public static void setExpiration(TextView expiration) {
        FridgeListItem.expiration = expiration;
    }

    public static void setExpiration(String expiration){
        FridgeListItem.expiration.setText(expiration);
    }
}
