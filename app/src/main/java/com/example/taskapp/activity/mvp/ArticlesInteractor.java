package com.example.taskapp.activity.mvp;

import com.example.taskapp.network.model.Results;

import java.util.List;

public interface ArticlesInteractor {


    interface OnFinishedListener {

        void onFinished(List<Results> articles);

        void onError(String msg);
    }


    void getMostPopular(OnFinishedListener listener);

}
