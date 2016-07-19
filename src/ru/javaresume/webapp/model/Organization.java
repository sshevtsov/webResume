package ru.javaresume.webapp.model;

import java.util.List;

/**
 * Created by deadRabbit on 17.07.2016.
 */
public class Organization {

    private Link homePage;
    private List<Position> periods;

    public Link getHomePage() {
        return homePage;
    }

    public void setHomePage(Link homePage) {
        this.homePage = homePage;
    }

    public List<Position> getPeriods() {
        return periods;
    }

    public void setPeriods(List<Position> periods) {
        this.periods = periods;
    }
}
