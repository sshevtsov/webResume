package ru.javaresume.webapp.model;

import java.util.List;

/**
 * Created by deadRabbit on 17.07.2016.
 */
public class ListSection extends Section {

    private List<String> lines;

    public ListSection(List<String> lines) {
        super("ListSection");
        this.lines = lines;
    }
}
