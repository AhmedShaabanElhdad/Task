package com.example.taskapp.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.ActionBar;
import android.app.ProgressDialog;
import android.os.Bundle;
import android.os.Handler;
import android.widget.Toast;

import com.example.taskapp.R;
import com.example.taskapp.activity.mvp.ArticlesInteractorImpl;
import com.example.taskapp.activity.mvp.ArticlesPresenter;
import com.example.taskapp.activity.mvp.ArticlesPresenterImpl;
import com.example.taskapp.activity.mvp.ArticlesView;
import com.example.taskapp.adapter.ArticlesAdapter;
import com.example.taskapp.network.model.Results;
import com.example.taskapp.utilities.Constant;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements ArticlesView {

    RecyclerView carsRecyclerView;
    ArticlesAdapter articlesAdapter;
    List<Results> articles;
    ArticlesPresenter presenter;
    private ProgressDialog progressDialog;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initRecyclerView();
        initView();
        intiAndCallPresenter();

    }

    private void initView() {
        progressDialog = new ProgressDialog(this);
    }

    private void intiAndCallPresenter() {
        presenter = new ArticlesPresenterImpl(this);
        presenter.getArticles(Constant.API_KEY);
    }

    private void initRecyclerView() {
        carsRecyclerView = findViewById(R.id.recycler_cars);
        carsRecyclerView.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));
        carsRecyclerView.setHasFixedSize(true);

        articles = new ArrayList<>();
        articlesAdapter = new ArticlesAdapter(articles, this);

        carsRecyclerView.setAdapter(articlesAdapter);
    }


    @Override
    public void showProgress() {

        if (!progressDialog.isShowing())
            new Handler().postDelayed(new Runnable() {
                @Override
                public void run() {
                    progressDialog.show();
                }
            }, 100);
    }


    @Override
    public void hideProgress() {
        if (progressDialog.isShowing())
            progressDialog.dismiss();
    }

    @Override
    public void showMessage(String message) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void getArticles(List<Results> articles) {
        articlesAdapter.setArticles(articles);
    }


    @Override
    protected void onDestroy() {
        super.onDestroy();
        presenter.onDestroy();
    }
}