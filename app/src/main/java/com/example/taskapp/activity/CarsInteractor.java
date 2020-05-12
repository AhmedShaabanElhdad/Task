package com.example.taskapp.activity;

import com.example.taskapp.network.Data;

import java.util.List;

public interface CarsInteractor {


    interface OnFinishedListener {

        void onFinished(List<Data> cars);

        void onError(String msg);
    }


    void getCars(int page, OnFinishedListener listener);

}
