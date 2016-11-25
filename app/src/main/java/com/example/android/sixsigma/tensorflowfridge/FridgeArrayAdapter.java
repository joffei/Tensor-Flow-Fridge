package com.example.android.sixsigma.tensorflowfridge;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by mobiledev on 11/25/2016.
 */

public class FridgeArrayAdapter extends ArrayAdapter<FridgeListItem> {

    FridgeArrayAdapter(Context context, ArrayList<FridgeListItem> fridgeItems){
        super(context, R.layout.fridge_list_item, fridgeItems);
    }

    @NonNull
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        FridgeListItem item = getItem(position);

        if(convertView == null){
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.fridge_list_item, parent, false);
        }

        ImageView imageView = (ImageView) convertView.findViewById(R.id.list_item_image);
        TextView name = (TextView) convertView.findViewById(R.id.list_item_name);
        TextView expiration = (TextView) convertView.findViewById(R.id.list_item_expire);

        imageView.setImageResource(item.getImageId());
        name.setText(item.getName().toString());
        expiration.setText(item.getExpiration().toString());

        return convertView;
    }
}
