package org.ulpgc.dacd.model;

import java.io.Serializable;
// public record Theater (String actors, String audience){}


public final class Theater implements Serializable {
    private final String actors;
    private final String location;

    public Theater(String actors, String location) {
        this.actors = actors;
        this.location = location;
    }

    public String getActors() {
        return actors;
    }

    public String getLocation() {
        return location;
    }
}
