package com.example.taskapp.adapter;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.example.taskapp.R;
import com.example.taskapp.network.Data;
import com.squareup.picasso.Picasso;

public class CarHolder extends RecyclerView.ViewHolder {



    private Context mContext;
    private ImageView img_status;
    private Button btn_finish;

    private TextView txt_isUsed,txt_brand;
    private ImageView img;


    View view;



    public CarHolder(View view) {
        super(view);


        txt_isUsed = (TextView) view.findViewById(R.id.txt_isused);
        txt_brand = (TextView) view.findViewById(R.id.txt_brand);
        img = (ImageView) view.findViewById(R.id.img);
        this.view = view;

    }

    public void bind(final Data car) {

        txt_isUsed.setText(String.valueOf(car.isUsed()));
        txt_brand.setText(car.getBrand());
        Picasso.with(img.getContext()).load(car.getImageUrl()).into(img);


    }


}
