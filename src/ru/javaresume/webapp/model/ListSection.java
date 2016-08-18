package ru.javaresume.webapp.model;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by deadRabbit on 17.07.2016.
 */
public class ListSection extends Section {

    private List<String> lines = new ArrayList<>();

    public ListSection( String... lines) {
        this(Arrays.asList(lines));
    }

    public ListSection(List<String> lines) {
        this.lines = lines;
    }

    @Override
    public String toString() {
        return "ListSection(" + lines.toString() + ")";
    }
}
