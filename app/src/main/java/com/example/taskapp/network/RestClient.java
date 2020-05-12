package com.example.taskapp.network;


import com.example.taskapp.utilities.Constant;

import java.io.IOException;

import okhttp3.HttpUrl;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RestClient {
    MockableApi mockableApi;


    public RestClient() {

        OkHttpClient.Builder client = new OkHttpClient().newBuilder();
        client.addInterceptor(new Interceptor() {
            @Override
            public Response intercept(Chain chain) throws IOException {

                HttpUrl url;
                Request request = chain.request();
                return chain.proceed(request);
            }
        });


        Retrofit retrofit = new Retrofit.Builder()
                .addConverterFactory(GsonConverterFactory.create())
                .baseUrl(Constant.DOMAIN)
                .client(client.build())
                .build();

        mockableApi = retrofit.create(MockableApi.class);
    }


    public MockableApi getApiService() {
        return mockableApi;
    }
}