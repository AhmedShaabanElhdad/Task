package com.example.taskapp.activity;

import com.example.taskapp.network.Data;

import java.util.List;


public interface CarsView {

    void showProgress();

    void hideProgress();

    void showMessage(String message);

    void getCars(List<Data> cars);

}
