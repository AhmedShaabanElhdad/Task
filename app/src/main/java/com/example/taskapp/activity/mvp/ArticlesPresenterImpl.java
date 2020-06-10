package com.example.taskapp.activity.mvp;


import com.example.taskapp.network.model.Results;

import java.util.List;


public class ArticlesPresenterImpl implements ArticlesPresenter, ArticlesInteractor.OnFinishedListener {

    private ArticlesView articlesView;
    private ArticlesInteractor articlesInteractor;

    public ArticlesPresenterImpl(ArticlesView articlesView, ArticlesInteractor articlesInteractor) {
        this.articlesView = articlesView;
        this.articlesInteractor = articlesInteractor;
    }


    @Override
    public void onResume() {

    }

    @Override
    public void getArticles() {
        if (articlesView != null) {
            articlesView.showProgress();
        }
        articlesInteractor.getMostPopular(this);
    }


    @Override
    public void onDestroy() {
        articlesView = null;
    }





    @Override
    public void onFinished(List<Results> articles) {
        if (articlesView != null) {
            articlesView.hideProgress();
            articlesView.getArticles(articles);
        }
    }

    @Override
    public void onError(String msg) {
        if (articlesView != null) {
            articlesView.showMessage(msg);
            articlesView.hideProgress();
        }
    }

}
