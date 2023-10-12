package org.ulpgc.dacd.model;

import java.io.Serializable;

public final class Session implements Serializable {
    //private final String film;
    private final String startTime;
    private Movie movie;
    private Theater theater;

    public Session(Movie movie, Theater theater, String startTime) {
        this.movie = movie;
        this.theater = theater;
        this.startTime = startTime;
    }

    public String getStartTime() {
        return startTime;
    }

    public Movie getMovie() {
        return movie;
    }

    public void setMovie(Movie movie) {
        this.movie = movie;
    }

    public Theater getTheater() {
        return theater;
    }

    public void setTheater(Theater theater) {
        this.theater = theater;
    }
}
