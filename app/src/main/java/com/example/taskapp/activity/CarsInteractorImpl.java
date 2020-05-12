package com.example.taskapp.activity;

import android.util.Log;

import com.example.taskapp.network.Data;
import com.example.taskapp.network.MockableApi;
import com.example.taskapp.network.RestClient;
import com.example.taskapp.network.ResultCarModel;
import com.google.gson.GsonBuilder;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;

public class CarsInteractorImpl implements CarsInteractor {

    @Override
    public void getCars(int page, final OnFinishedListener listener) {
        //i initialize here as i just will use it one time
        RestClient restClient = new RestClient();
        MockableApi mockableApi = restClient.getApiService();


        Call<ResultCarModel> connection = mockableApi.getCars(page);
        connection.enqueue(new Callback<ResultCarModel>() {
            @Override
            public void onResponse(Call<ResultCarModel> call, retrofit2.Response<ResultCarModel> response) {

                Log.e("getEvents response", new GsonBuilder().setPrettyPrinting().create().toJson(response));
                Log.e("getEvents url", response.raw().request().url() + "");

                int status = response.body().getStatus();
                if (status == 1) {

                    List<Data> cars = response.body().getData();
                    listener.onFinished(cars);

                } else {
                    listener.onError(response.body().getError().getMessage());
                }
            }

            @Override
            public void onFailure(Call<ResultCarModel> call, Throwable t) {
                listener.onError(t.getMessage());

            }
        });
    }


}
