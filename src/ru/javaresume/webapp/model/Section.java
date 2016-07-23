package ru.javaresume.webapp.model;

/**
 * Created by deadRabbit on 17.07.2016.
 */
public abstract class Section {

    private String type;

    protected Section(String type) {
        this.type = type;
    }
}
