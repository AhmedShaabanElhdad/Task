package com.example.taskapp.activity.mvp;

import com.example.taskapp.network.model.Response;
import com.example.taskapp.network.model.Results;

import java.util.List;

import io.reactivex.Observable;

public interface ArticlesInteractor {

    Observable<Response> getMostPopular(String key);

}
