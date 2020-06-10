package com.example.taskapp.activity.mvp;

import android.util.Log;

import com.example.taskapp.network.model.Fault;
import com.example.taskapp.network.model.Response;
import com.example.taskapp.network.model.RestClient;
import com.example.taskapp.network.model.Results;
import com.example.taskapp.network.MostPopularApi;
import com.example.taskapp.utilities.Constant;
import com.google.gson.GsonBuilder;

import java.util.List;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;
import retrofit2.Call;
import retrofit2.Callback;

public class ArticlesInteractorImpl implements ArticlesInteractor {

    OnFinishedListener listener;


    @Override
    public void getMostPopular(final OnFinishedListener listener) {

        this.listener=listener;

        //i initialize here as i just will use it one time
        RestClient restClient = new RestClient();
        MostPopularApi mostPopularApi = restClient.getApiService();


        //Using Call Back Function
        Call<Response> connection = mostPopularApi.getMostPopular(Constant.API_KEY);
        connection.enqueue(new Callback<Response>() {
            @Override
            public void onResponse(Call<Response> call, retrofit2.Response<Response> response) {

                Log.e("getEvents response", new GsonBuilder().setPrettyPrinting().create().toJson(response));
                Log.e("getEvents url", response.raw().request().url() + "");

                String status = response.body().getStatus();
                if (status != null && status.equals("OK")) {

                    List<Results> cars = response.body().getResults();
                    listener.onFinished(cars);

                } else {
                    Fault fault = response.body().getFault();
                    if (fault != null)
                        listener.onError(response.body().getFault().getFaultstring());
                }
            }

            @Override
            public void onFailure(Call<Response> call, Throwable t) {
                listener.onError(t.getMessage());

            }
        });




        // Use RxJava If Want

        /*
        mostPopularApi.getMostPopularArticle(Constant.API_KEY)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(this::onSuccess, this::onError);

         */

    }


    private void onError(Throwable throwable) {
        listener.onError(throwable.getMessage());
    }

    private void onSuccess(Response response) {
        listener.onFinished(response.getResults());
    }


}
