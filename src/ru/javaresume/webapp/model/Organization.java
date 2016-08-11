package ru.javaresume.webapp.model;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;

/**
 * Created by deadRabbit on 17.07.2016.
 */
public class Organization {

    private Link homePage;
    private List<Position> positions;

    public Organization(String name, String url, Position... positions) {
        this(new Link(name, url), Arrays.asList(positions));
    }

    public Organization(Link homePage, List<Position> periods) {
        this.homePage = homePage;
        this.positions = periods;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Organization that = (Organization) o;

        return Objects.equals(homePage, that.homePage) &&
                Objects.equals(positions, that.positions);

    }

    @Override
    public int hashCode() {
        return Objects.hash(homePage, positions);
    }

    @Override
    public String toString() {
        return "Organization(" + homePage + ", " + positions + ")";
    }
}
