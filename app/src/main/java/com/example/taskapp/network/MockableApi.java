package com.example.taskapp.network;

import io.reactivex.Observable;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface MockableApi {


    @GET("cars")
    Call<ResultCarModel> getCars(
            @Query("page") int page
    );
}
