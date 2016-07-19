package ru.javaresume.webapp.model;

import java.util.Date;

/**
 * Created by deadRabbit on 17.07.2016.
 */
public class Position {

    private Date startDate;
    private Date endDate;
    private String title;
    private String description;

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
