package com.example.taskapp.activity.mvp;

import com.example.taskapp.network.model.Results;

import java.util.List;


public interface ArticlesView {

    void showProgress();

    void hideProgress();

    void showMessage(String message);

    void getArticles(List<Results> articles);

}
