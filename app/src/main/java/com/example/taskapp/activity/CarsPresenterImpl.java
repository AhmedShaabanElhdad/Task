package com.example.taskapp.activity;

import com.example.taskapp.network.Data;

import java.util.List;


public class CarsPresenterImpl implements CarsPresenter, CarsInteractor.OnFinishedListener {

    private CarsView carsView;
    private CarsInteractor carsInteractor;

    public CarsPresenterImpl(CarsView carsView, CarsInteractor carsInteractor) {
        this.carsView = carsView;
        this.carsInteractor = carsInteractor;
    }


    @Override
    public void onResume() {
        if (carsView != null) {
            carsView.showProgress();
        }
    }

    @Override
    public void getcars(int page) {
        carsInteractor.getCars(page,this);
    }


    @Override
    public void onDestroy() {
        carsView = null;
    }





    @Override
    public void onFinished(List<Data> cars) {
        if (carsView != null) {
            carsView.getCars(cars);
        }
    }

    @Override
    public void onError(String msg) {
        if (carsView != null) {
            carsView.showMessage(msg);
            carsView.hideProgress();
        }
    }

}
