package com.example.taskapp.network.model;


public class Fault {
    private final String faultstring;

    private final Detail detail;

    public Fault(String faultstring, Detail detail) {
        this.faultstring = faultstring;
        this.detail = detail;
    }

    public String getFaultstring() {
        return faultstring;
    }

    public Detail getDetail() {
        return detail;
    }

    public class Detail {
        private final String errorcode;

        public Detail(String errorcode) {
            this.errorcode = errorcode;
        }

        public String getErrorcode() {
            return errorcode;
        }
    }
}

