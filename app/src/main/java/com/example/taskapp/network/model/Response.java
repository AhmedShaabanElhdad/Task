package com.example.taskapp.network.model;

import java.util.List;


public class Response {
    private final String status;

    private final String copyright;

    private final int numResults;

    private Fault fault;

    private final List<Results> results;

    public Response(String status, String copyright, int numResults, List<Results> results) {
        this.status = status;
        this.copyright = copyright;
        this.numResults = numResults;
        this.results = results;
    }

    public String getStatus() {
        return status;
    }

    public String getCopyright() {
        return copyright;
    }

    public int getNumResults() {
        return numResults;
    }

    public List<Results> getResults() {
        return results;
    }

    public Fault getFault() {
        return fault;
    }

    public void setFault(Fault fault) {
        this.fault = fault;
    }
}
