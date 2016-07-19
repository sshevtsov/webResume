package ru.javaresume.webapp.model;

import java.util.List;

/**
 * Created by deadRabbit on 17.07.2016.
 */
public class ListSection extends Section{

    private List<String> lines;

    public List<String> getLines() {
        return lines;
    }

    public void setLines(List<String> lines) {
        this.lines = lines;
    }
}
