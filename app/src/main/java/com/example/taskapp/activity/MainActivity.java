package com.example.taskapp.activity;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.AbsListView;
import android.widget.Toast;

import com.example.taskapp.R;
import com.example.taskapp.adapter.CarAdapter;
import com.example.taskapp.network.Data;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements CarsView {

    RecyclerView carsRecyclerView;
    CarAdapter carAdapter;
    List<Data> cars;
    CarsPresenter presenter;
    private boolean isScrolling = false;
    private int page = 1;
    private boolean loading = true;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        carsRecyclerView = findViewById(R.id.recycler_cars);
        carsRecyclerView.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));
        carsRecyclerView.setHasFixedSize(true);

        cars = new ArrayList<>();
        carAdapter = new CarAdapter(cars, this);

        carsRecyclerView.setAdapter(carAdapter);
        carsRecyclerView.addOnScrollListener(new RecyclerView.OnScrollListener() {
            @Override
            public void onScrollStateChanged(@NonNull RecyclerView recyclerView, int newState) {
                super.onScrollStateChanged(recyclerView, newState);
                if (newState == AbsListView.OnScrollListener.SCROLL_STATE_TOUCH_SCROLL)
                    isScrolling = true;
            }

            @Override
            public void onScrolled(@NonNull RecyclerView recyclerView, int dx, int dy) {
                super.onScrolled(recyclerView, dx, dy);

                LinearLayoutManager mLayoutManager = (LinearLayoutManager) recyclerView.getLayoutManager();

                int visibleItemCount = mLayoutManager.getChildCount();
                int totalItemCount = mLayoutManager.getItemCount();
                int pastVisiblesItems = mLayoutManager.findFirstVisibleItemPosition();

                if (isScrolling) {
                    if ((visibleItemCount + pastVisiblesItems) >= totalItemCount) {
                        loading = false;
                        isScrolling = false;
                        page++;
                        presenter.getcars(page);
                    }
                }


            }
        });


        presenter = new CarsPresenterImpl(this, new CarsInteractorImpl());
        presenter.getcars(page);
    }


    @Override
    public void showProgress() {

    }

    @Override
    public void hideProgress() {

    }

    @Override
    public void showMessage(String message) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void getCars(List<Data> cars) {
        carAdapter.setCars(cars);
    }
}