package com.example.covidapp;


public class Covidcases {
    private String date,active,recovered,deaths;
    public Covidcases(String date, String active, String recovered, String deaths) {
        this.date=date;
        this.active=active;
        this.recovered=recovered;
        this.deaths=deaths;
    }

    public String getDate() {

        return date;
    }

    public String getActive() {

        return active;
    }

    public String getRecovered() {

        return recovered;
    }

    public String getDeaths() {

        return deaths;
    }
}
