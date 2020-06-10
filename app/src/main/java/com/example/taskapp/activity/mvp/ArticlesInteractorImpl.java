package com.example.taskapp.activity.mvp;

import com.example.taskapp.network.model.Response;
import com.example.taskapp.network.model.RestClient;
import com.example.taskapp.network.MostPopularApi;
import com.example.taskapp.utilities.Constant;

import io.reactivex.Observable;
import io.reactivex.Scheduler;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

public class ArticlesInteractorImpl implements ArticlesInteractor {


    private Scheduler subscribeOn;
    private Scheduler observableOn;
    private MostPopularApi mostPopularApi;

    ArticlesInteractorImpl(){


        //i initialize here as i just will use it one time
        RestClient restClient = new RestClient();
        mostPopularApi = restClient.getApiService();

        this.subscribeOn = Schedulers.io();
        this.observableOn = AndroidSchedulers.mainThread();
    }

    // non public constructor for Unit testing :
    ArticlesInteractorImpl(MostPopularApi api, Scheduler testScheduler) {
        this.mostPopularApi = api;
        this.subscribeOn = testScheduler;
        this.observableOn = testScheduler;
    }

    @Override
    public Observable<Response> getMostPopular(String key) {


        // Use RxJava If Want


        return mostPopularApi.getMostPopularArticle(key)
                .subscribeOn(this.subscribeOn)
                .observeOn(observableOn);


        /*
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

         */
    }
}
