package com.example.taskapp.activity.mvp;

public interface ArticlesPresenter {

    void onResume();

    void getArticles(String key);

    void onDestroy();

}
