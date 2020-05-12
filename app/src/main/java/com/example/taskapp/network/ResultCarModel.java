package com.example.taskapp.network;

import java.util.List;

public class ResultCarModel{
    List<Data> data;
    int status;
    Error error;

    public ResultCarModel(List<Data> data, int status) {
        this.data = data;
        this.status = status;
    }


    public List<Data> getData() {
        return data;
    }

    public int getStatus() {
        return status;
    }

    public Error getError() {
        return error;
    }


}