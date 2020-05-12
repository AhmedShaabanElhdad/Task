package com.example.taskapp.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.recyclerview.widget.RecyclerView;

import com.example.taskapp.R;
import com.example.taskapp.network.Data;

import java.util.List;

public class CarAdapter extends RecyclerView.Adapter<CarHolder> {

    private List<Data> cars;
    private Context mContext;

    public CarAdapter(List<Data> cars, Context context) {
        mContext = context;
        this.cars = cars;
    }

    @Override
    public CarHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view;
        view = LayoutInflater.from(mContext).inflate(R.layout.car_item, parent, false);
        return new CarHolder(view);
    }

    @Override
    public void onBindViewHolder(CarHolder holder, int position) {
        holder.bind(cars.get(position));
    }

    @Override
    public int getItemCount() {
        return cars.size();
    }

    public void setCars(List<Data> cars) {
        this.cars = cars;
        notifyDataSetChanged();
    }
}
