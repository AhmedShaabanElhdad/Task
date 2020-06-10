package com.example.taskapp.activity.mvp;


import com.example.taskapp.network.model.Response;
import com.example.taskapp.network.model.Results;
import com.example.taskapp.utilities.Constant;

import java.util.List;

import io.reactivex.disposables.Disposable;


public class ArticlesPresenterImpl implements ArticlesPresenter {

    private ArticlesView articlesView;
    private ArticlesInteractor articlesInteractor;
    private Disposable disposable;

    public ArticlesPresenterImpl(ArticlesView articlesView) {
        this.articlesView = articlesView;
        this.articlesInteractor = new ArticlesInteractorImpl();
    }

    // non public constructor for Unit testing :
    ArticlesPresenterImpl(ArticlesInteractorImpl model,ArticlesView view) {
        this.articlesView = view;
        this.articlesInteractor = model;
    }

    @Override
    public void onResume() {

    }

    @Override
    public void getArticles(String key) {
        if (articlesView != null) {
            articlesView.showProgress();
        }
        if (disposable == null) {
            disposable = articlesInteractor.getMostPopular(key).subscribe(this::onSuccess, this::onError);
        }
    }

    private void onError(Throwable throwable) {
        if (articlesView != null) {
            articlesView.showMessage(throwable.getMessage());
            articlesView.hideProgress();
        }
        disposable = null;
    }

    private void onSuccess(Response response) {
        if (articlesView != null) {
            articlesView.hideProgress();
            articlesView.getArticles(response.getResults());
        }
        disposable = null;
    }


    @Override
    public void onDestroy() {
        articlesView = null;
        if (disposable != null && !disposable.isDisposed()) {
            disposable.dispose();
        }
        disposable = null;
    }


}
