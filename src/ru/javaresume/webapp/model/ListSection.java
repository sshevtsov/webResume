package ru.javaresume.webapp.model;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by deadRabbit on 17.07.2016.
 */
public class ListSection extends Section {

    private List<String> lines = new ArrayList<>();

    public ListSection(SectionType type, String... lines) {
        this(type, Arrays.asList(lines));
    }

    public ListSection(SectionType type, List<String> lines) {
        super(type);
        this.lines = lines;
    }

    @Override
    public String toString() {
        return "ListSection(" + lines.toString() + ")";
    }
}
