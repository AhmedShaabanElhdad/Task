package com.example.taskapp.network;

import com.example.taskapp.network.model.Response;

import io.reactivex.Observable;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface MostPopularApi {


    @GET("emailed/7.json")
    Call<Response> getMostPopular(
            @Query("api-key") String apiKey
    );

    @GET("emailed/7.json")
    Observable<Response> getMostPopularArticle(
            @Query("api-key") String apiKey
    );
}
