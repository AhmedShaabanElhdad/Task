package com.example.taskapp.activity.mvp;

import android.util.Log;

import com.example.taskapp.network.MockMostPopularApi;
import com.example.taskapp.network.model.Results;

import org.junit.Assert;
import org.junit.Test;

import java.util.List;

import io.reactivex.schedulers.TestScheduler;

import static org.junit.Assert.*;

public class ArticlesPresenterTest {


    @Test
    public void onGetArticleWithCorrectApiKeyThenReturnResult() {

        // arrange :

        final boolean[] result = {false};
        TestScheduler testScheduler = new TestScheduler();
        ArticlesInteractorImpl model = new ArticlesInteractorImpl(new MockMostPopularApi(), testScheduler);
        ArticlesPresenter presenter = new ArticlesPresenterImpl(model,new ArticlesView() {
            @Override
            public void showProgress() {

            }

            @Override
            public void hideProgress() {

            }

            @Override
            public void showMessage(String message) {

            }

            @Override
            public void getArticles(List<Results> articles) {
                result[0]=true;
            }
        });

        // act :
        presenter.getArticles("e35GK0qE5zrGM5QENdCDu1CtdlZHmGPt");
        testScheduler.triggerActions();

        // assert :
        Assert.assertTrue(result[0]);
    }
    @Test
    public void onGetArticleWithInCorrectApiKeyThenReturnError() {

        // arrange :

        final boolean[] result = {false};
        TestScheduler testScheduler = new TestScheduler();
        ArticlesInteractorImpl model = new ArticlesInteractorImpl(new MockMostPopularApi(), testScheduler);
        ArticlesPresenter presenter = new ArticlesPresenterImpl(model,new ArticlesView() {
            @Override
            public void showProgress() {

            }

            @Override
            public void hideProgress() {

            }

            @Override
            public void showMessage(String message) {
                result[0]=true;
            }

            @Override
            public void getArticles(List<Results> articles) {

            }
        });

        // act :
        presenter.getArticles("e35GK0qE5zrGM5QENdCDu1CtdlZ");
        testScheduler.triggerActions();

        // assert :
        Assert.assertTrue(result[0]);
    }

}