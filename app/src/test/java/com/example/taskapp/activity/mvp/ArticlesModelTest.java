package com.example.taskapp.activity.mvp;

import com.example.taskapp.network.MockMostPopularApi;
import com.example.taskapp.network.model.Response;

import org.junit.Assert;
import org.junit.Test;

import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.TestScheduler;

import static org.junit.Assert.*;

public class ArticlesModelTest {

    @Test
    public void requestApiWithCorrectKeyThenReturnResponse() {

        // arrange :

        final boolean[] result = {false};
        TestScheduler testScheduler = new TestScheduler();
        ArticlesInteractorImpl model = new ArticlesInteractorImpl(new MockMostPopularApi(), testScheduler);

        // act
        model.getMostPopular("e35GK0qE5zrGM5QENdCDu1CtdlZHmGPt").subscribe(new Consumer<Response>() {
            public void accept(Response s) {
                result[0] = true;
            }
        });

        testScheduler.triggerActions(); // execute all pending RX operations

        // assert
        Assert.assertTrue(result[0]);
    }

    @Test public void requestApiWithNotCorrectKeyThenReturnError() {

        // arrange :

        final boolean[] result = {false};
        TestScheduler testScheduler = new TestScheduler();
        ArticlesInteractorImpl model = new ArticlesInteractorImpl(new MockMostPopularApi(), testScheduler);

        // act
        model.getMostPopular("e35GK0qE5zrGM5QENdCDu1CtdlZHmGPts").subscribe(new Consumer<Response>() {
            public void accept(Response s) {
            }
        }, new Consumer<Throwable>() {
            public void accept(Throwable throwable) {
                result[0] = true;
            }
        });

        testScheduler.triggerActions(); // execute all pending RX operations

        // assert
        Assert.assertTrue(result[0]);
    }



}