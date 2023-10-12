package org.ulpgc.dacd.model;

import java.io.Serializable;
import java.util.Objects;

public final class Movie implements Serializable {
    private final String name;
    private final String director;

    public Movie(String name, String director) {
        this.name = name;
        this.director = director;
    }

    public String getName() {
        return name;
    }
    public String getDirector() {
        return director;
    }
}
