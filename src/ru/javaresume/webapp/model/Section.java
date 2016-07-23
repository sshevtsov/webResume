package ru.javaresume.webapp.model;

import java.util.Objects;

/**
 * Created by deadRabbit on 17.07.2016.
 */
public abstract class Section {

    private final SectionType type;

    protected Section(SectionType type) {
        this.type = type;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Section section = (Section) o;
        return type == section.type;
    }

    @Override
    public int hashCode() {
        return Objects.hash(type);
    }

    @Override
    public String toString() {
        return "Section (" + type + ")";
    }
}
